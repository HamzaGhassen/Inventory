package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionCreateDTO;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionResponseDTO;
import tn.ghassen.inventory.dto.FinancialTransaction.FinancialTransactionUpdateDTO;
import tn.ghassen.inventory.entity.FinancialTransaction;

@Component
public class FinancialTransactionMapper {

    public FinancialTransaction toEntity(FinancialTransactionCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        FinancialTransaction financialTransaction = new FinancialTransaction();
        financialTransaction.setDescription(dto.description());
        financialTransaction.setAmount(dto.amount());
        financialTransaction.setTransactionType(dto.transactionType());
        financialTransaction.setPaymentMethod(dto.paymentMethod());
        financialTransaction.setPaymentStatus(dto.paymentStatus());

        return financialTransaction;
    }

    public FinancialTransactionResponseDTO toResponseDTO(FinancialTransaction financialTransaction) {
        if (financialTransaction == null) {
            return null;
        }

        return new FinancialTransactionResponseDTO(
                financialTransaction.getId(),
                financialTransaction.getDescription(),
                financialTransaction.getAmount(),
                financialTransaction.getTransactionType(),
                financialTransaction.getPaymentMethod(),
                financialTransaction.getPaymentStatus(),
                financialTransaction.getCompany() != null ? financialTransaction.getCompany().getId() : null,
                financialTransaction.getUser() != null ? financialTransaction.getUser().getId() : null,
                financialTransaction.getSale() != null ? financialTransaction.getSale().getId() : null,
                financialTransaction.getPurchase() != null ? financialTransaction.getPurchase().getId() : null,
                financialTransaction.getExpense() != null ? financialTransaction.getExpense().getId() : null,
                financialTransaction.getCreatedAt(),
                financialTransaction.getUpdatedAt()
        );
    }

    public FinancialTransactionResponseDTO toResponse(FinancialTransaction financialTransaction) {
        return toResponseDTO(financialTransaction);
    }

    public void updateEntity(FinancialTransaction financialTransaction, FinancialTransactionUpdateDTO dto) {
        if (financialTransaction == null || dto == null) {
            return;
        }

        if (dto.description() != null) {
            financialTransaction.setDescription(dto.description());
        }
        if (dto.amount() != null) {
            financialTransaction.setAmount(dto.amount());
        }
        if (dto.transactionType() != null) {
            financialTransaction.setTransactionType(dto.transactionType());
        }
        if (dto.paymentMethod() != null) {
            financialTransaction.setPaymentMethod(dto.paymentMethod());
        }
        if (dto.paymentStatus() != null) {
            financialTransaction.setPaymentStatus(dto.paymentStatus());
        }
    }
}
