package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense createExpense(Expense expense);

    Expense getExpenseById(Long id);

    List<Expense> getAllExpenses();

    Expense updateExpense(Long id ,Expense expense);

    void deleteExpense(Long id);

}
