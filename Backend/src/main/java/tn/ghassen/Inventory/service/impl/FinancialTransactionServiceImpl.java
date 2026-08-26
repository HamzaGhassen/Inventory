package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionCreateDTO;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionResponseDTO;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionUpdateDTO;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.entity.FinancialTransaction;
import tn.ghassen.inventory.entity.User;
import tn.ghassen.inventory.mapper.FinancialTransactionMapper;
import tn.ghassen.inventory.repository.FinancialTransactionRepository;
import tn.ghassen.inventory.repository.UserRepository;
import tn.ghassen.inventory.dto.authorization.AuthorizationRequest;
import tn.ghassen.inventory.dto.authorization.AuthorizationResponse;
import tn.ghassen.inventory.enums.Role;
import tn.ghassen.inventory.service.AuthorizationService;
import tn.ghassen.inventory.service.FinancialTransactionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialTransactionServiceImpl implements FinancialTransactionService {

    private final FinancialTransactionRepository financialTransactionRepository;
    private final FinancialTransactionMapper financialTransactionMapper;
    private final UserRepository userRepository;
    private final AuthorizationService authorizationService;

    @Override
    public FinancialTransactionResponseDTO createFinancialTransaction(FinancialTransactionCreateDTO dto) {
        FinancialTransaction finance = financialTransactionMapper.toEntity(dto);
        FinancialTransaction savedFinance = financialTransactionRepository.save(finance);

        return financialTransactionMapper.toResponseDTO(savedFinance);
    }

    @Override
    public FinancialTransactionResponseDTO getFinancialTransactionById(Long id) {
        FinancialTransaction finance = financialTransactionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Financial transaction not found with id: " + id));
        // Right thing to do after knowing the need of checking the Active User and his Company
        Company company = finance.getCompany();
        User currentUser = getAuthenticatedUser();


        if (company == null) {
            throw new RuntimeException("There is no associated company for this Transaction");
        }

        if (!finance.getUser().getId().equals(currentUser.getId())){
            throw new RuntimeException("you are not allowed to see this transaction");
        }
        // this Layer are there to help Trackers to see What This Security Action Via Exception
        if (!currentUser.getCompany().getId().equals(company.getId())) {
            throw new RuntimeException(
                    "This financial transaction does not belong to the current company"
            );
        }

        return financialTransactionMapper.toResponseDTO(finance);

    }

    @Override
    public List<FinancialTransactionResponseDTO> getAllFinancialTransaction() {

        User currentUser = getAuthenticatedUser();
        Company company = currentUser.getCompany();

        if (!Role.MANAGER.equals(currentUser.getRole())) {
            throw new RuntimeException("you are not authorized to access the Financial Transaction List");
        }
        if (company == null){
            throw new RuntimeException("there is no associated company");
        }
        return financialTransactionRepository.findByCompanyId(company.getId())
                .stream()
                .map(financialTransactionMapper::toResponseDTO)
                .toList();

    }

    @Override
    public FinancialTransactionResponseDTO updateFinancialTransaction(
            Long id,
            FinancialTransactionUpdateDTO dto) {

        FinancialTransaction existing = financialTransactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Financial transaction not found with id: " + id
                        ));

        User currentUser = getAuthenticatedUser();

        if (!getAuthorized(currentUser, existing)) {
            throw new RuntimeException(
                    "This user is not authorized to update this financial transaction"
            );
        }

        financialTransactionMapper.updateEntity(existing, dto);

        FinancialTransaction updated =
                financialTransactionRepository.save(existing);

        return financialTransactionMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteFinancialTransaction(Long id) {
    financialTransactionRepository.deleteById(id);
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

    private boolean getAuthorized(User currentUser, FinancialTransaction finance) {

        // Build the authorization request
        AuthorizationRequest request = new AuthorizationRequest(
                currentUser.getId(),
                finance.getId(),
                "UPDATE"
        );

        // Send request to the authorization system
        AuthorizationResponse response =
                authorizationService.checkAuthorization(request);

        // Return the decision received from the authorization system
        return response.isAuthorized();
    }
}
