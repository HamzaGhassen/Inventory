package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.Expense.ExpenseCreateDTO;
import tn.ghassen.inventory.dto.Expense.ExpenseResponseDTO;
import tn.ghassen.inventory.dto.Expense.ExpenseUpdateDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseDTO createExpense(ExpenseCreateDTO dto);

    ExpenseResponseDTO getExpenseById(Long id);

    List<ExpenseResponseDTO> getAllExpenses();

    ExpenseResponseDTO updateExpense(Long id, ExpenseUpdateDTO dto);

    void deleteExpense(Long id);
}
