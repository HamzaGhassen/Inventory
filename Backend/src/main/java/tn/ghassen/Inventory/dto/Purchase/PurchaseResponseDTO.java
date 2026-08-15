package tn.ghassen.inventory.dto.Purchase;

import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseResponseDTO (
        Long purchaseId,
        Long supplierId,
        Long userId,
        Long companyId,
        BigDecimal totalAmount,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        LocalDateTime createdAt
)
{
}
