package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.FinancialTransaction;
import tn.ghassen.inventory.repository.FinancialTransactionRepository;
import tn.ghassen.inventory.service.FinancialTransactionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialTransactionServiceImpl implements FinancialTransactionService {

    private final FinancialTransactionRepository financialTransactionRepository;

    @Override
    public FinancialTransaction createFinancialTransaction(FinancialTransaction financialTransaction) {
        return financialTransactionRepository.save(financialTransaction);
    }

    @Override
    public FinancialTransaction getFinancialTransactionById(Long id) {
        return financialTransactionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("financial_Transaction not found"));
    }

    @Override
    public List<FinancialTransaction> getAllFinancialTransaction() {
        return financialTransactionRepository.findAll();
    }

    @Override
    public FinancialTransaction updateFinancialTransaction(Long id, FinancialTransaction financialTransaction) {

        FinancialTransaction existing = getFinancialTransactionById(id);

        existing.setDescription(financialTransaction.getDescription());
        existing.setAmount(financialTransaction.getAmount());
        existing.setTransactionType(financialTransaction.getTransactionType());
        existing.setPaymentMethod(financialTransaction.getPaymentMethod());
        existing.setPaymentStatus(financialTransaction.getPaymentStatus());

        return financialTransactionRepository.save(existing);
    }

    @Override
    public void deleteFinancialTransaction(Long id) {
    financialTransactionRepository.deleteById(id);
    }
}
