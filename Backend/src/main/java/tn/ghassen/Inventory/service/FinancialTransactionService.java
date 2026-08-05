package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.FinancialTransaction;

import java.util.List;

public interface FinancialTransactionService {

    FinancialTransaction createFinancialTransaction(FinancialTransaction financialTransaction);

    FinancialTransaction getFinancialTransactionById(Long id);

    List<FinancialTransaction> getAllFinancialTransaction();

    FinancialTransaction updateFinancialTransaction(Long id, FinancialTransaction financialTransaction);

    void deleteFinancialTransaction(Long id);
}
