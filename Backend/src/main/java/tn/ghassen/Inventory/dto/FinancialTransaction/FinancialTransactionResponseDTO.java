package tn.ghassen.inventory.dto.FinancialTransaction;

import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;
import tn.ghassen.inventory.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinancialTransactionResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        TransactionType transactionType,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus,
        Long companyId,
        Long userId,
        Long saleId,
        Long purchaseId,
        Long expenseId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
