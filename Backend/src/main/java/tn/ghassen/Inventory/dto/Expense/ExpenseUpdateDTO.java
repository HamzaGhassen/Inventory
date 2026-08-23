package tn.ghassen.inventory.dto.Expense;

import tn.ghassen.inventory.enums.ExpenseCategory;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;

public record ExpenseUpdateDTO(
        String description,
        BigDecimal amount,
        ExpenseCategory category,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus,
        Long supplierId
) {
}
