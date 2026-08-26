package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionCreateDTO;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionResponseDTO;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionUpdateDTO;

import java.util.List;

public interface FinancialTransactionService {

    FinancialTransactionResponseDTO createFinancialTransaction(FinancialTransactionCreateDTO dto);

    FinancialTransactionResponseDTO getFinancialTransactionById(Long id);

    List<FinancialTransactionResponseDTO> getAllFinancialTransaction();

    FinancialTransactionResponseDTO updateFinancialTransaction(Long id, FinancialTransactionUpdateDTO dto);

    void deleteFinancialTransaction(Long id);
}
