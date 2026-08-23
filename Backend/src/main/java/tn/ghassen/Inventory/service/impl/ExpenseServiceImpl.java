package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.Expense.ExpenseCreateDTO;
import tn.ghassen.inventory.dto.Expense.ExpenseResponseDTO;
import tn.ghassen.inventory.dto.Expense.ExpenseUpdateDTO;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.entity.Expense;
import tn.ghassen.inventory.entity.Supplier;
import tn.ghassen.inventory.entity.User;
import tn.ghassen.inventory.mapper.ExpenseMapper;
import tn.ghassen.inventory.repository.ExpenseRepository;
import tn.ghassen.inventory.repository.SupplierRepository;
import tn.ghassen.inventory.repository.UserRepository;
import tn.ghassen.inventory.service.ExpenseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public ExpenseResponseDTO createExpense(ExpenseCreateDTO dto) {
        // 1. Automatically identify currently authenticated User
        User currentUser = getAuthenticatedUser();

        // 2. Automatically obtain Company from authenticated User
        Company company = currentUser.getCompany();
        if (company == null) {
            throw new RuntimeException("Company not found for authenticated user: " + currentUser.getEmail());
        }

        // 3. Map basic fields using mapper (no DB logic inside mapper)
        Expense expense = expenseMapper.toEntity(dto);

        // 4. Assign mandatory user and company
        expense.setUser(currentUser);
        expense.setCompany(company);

        // 5. Optional supplier resolution
        if (dto.supplierId() != null) {
            Supplier supplier = supplierRepository.findById(dto.supplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + dto.supplierId()));
            expense.setSupplier(supplier);
        } else {
            expense.setSupplier(null);
        }

        Expense savedExpense = expenseRepository.save(expense);
        return expenseMapper.toResponseDTO(savedExpense);
    }

    @Override
    public ExpenseResponseDTO getExpenseById(Long id) {
        User currentUser = getAuthenticatedUser();

        Company company = currentUser.getCompany();
        if (company == null) {
            throw new RuntimeException("Company not found for authenticated user: " + currentUser.getEmail());
        }

        Expense expense = expenseRepository.findByIdAndCompanyId(id, company.getId())
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        return expenseMapper.toResponseDTO(expense);
    }

    @Override
    public List<ExpenseResponseDTO> getAllExpenses() {
        User currentUser = getAuthenticatedUser();
        Company company = currentUser.getCompany();
        if (company == null) {
            throw new RuntimeException("Company not found for authenticated user: " + currentUser.getEmail());
        }

        return expenseRepository.findByCompanyId(company.getId())
                .stream()
                .map(expenseMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ExpenseResponseDTO updateExpense(Long id, ExpenseUpdateDTO dto) {
        User currentUser = getAuthenticatedUser();
        Company company = currentUser.getCompany();
        if (company == null) {
            throw new RuntimeException("Company not found for authenticated user: " + currentUser.getEmail());
        }

        Expense existing = expenseRepository.findByIdAndCompanyId(id, company.getId())
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        expenseMapper.updateEntity(existing, dto);

        // Optional supplier resolution for update
        if (dto.supplierId() != null) {
            Supplier supplier = supplierRepository.findById(dto.supplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + dto.supplierId()));
            existing.setSupplier(supplier);
        }

        Expense updatedExpense = expenseRepository.save(existing);
        return expenseMapper.toResponseDTO(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        User currentUser = getAuthenticatedUser();
        Company company = currentUser.getCompany();
        if (company == null) {
            throw new RuntimeException("Company not found for authenticated user: " + currentUser.getEmail());
        }

        Expense existing = expenseRepository.findByIdAndCompanyId(id, company.getId())
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        expenseRepository.delete(existing);
    }

    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            throw new RuntimeException("Authenticated user not found in Security Context");
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof User user) {
            return user;
        }

        String email;
        if (principal instanceof UserDetails userDetails) {
            email = userDetails.getUsername();
        } else if (principal instanceof String str) {
            email = str;
        } else {
            email = authentication.getName();
        }

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Authenticated user not found with email: " + email));
    }
}
