package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Expense;
import tn.ghassen.inventory.repository.ExpenseRepository;
import tn.ghassen.inventory.service.ExpenseService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException ("expense not found"));
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense existing = getExpenseById(id);

        existing.setDescription(expense.getDescription());
        existing.setAmount(expense.getAmount());
        existing.setCategory(expense.getCategory());
        existing.setPaymentMethod(expense.getPaymentMethod());
        existing.setPaymentStatus(expense.getPaymentStatus());

        return expenseRepository.save(existing);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
