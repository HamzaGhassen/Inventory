package tn.ghassen.inventory.dto.Purchase;

import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemResponseDTO;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PurchaseResponseDTO (
        Long purchaseId,
        Long supplierId,
        Long userId,
        Long companyId,
        BigDecimal totalAmount,
        List<PurchaseItemResponseDTO> purchaseItems,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        LocalDateTime createdAt,
        LocalDateTime updateAt
)
{
}
