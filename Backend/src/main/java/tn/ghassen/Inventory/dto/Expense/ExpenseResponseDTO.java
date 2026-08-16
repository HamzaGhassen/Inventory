package tn.ghassen.inventory.dto.Expense;

import tn.ghassen.inventory.enums.ExpenseCategory;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        ExpenseCategory category,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus,
        Long userId,
        Long companyId,
        Long supplierId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
