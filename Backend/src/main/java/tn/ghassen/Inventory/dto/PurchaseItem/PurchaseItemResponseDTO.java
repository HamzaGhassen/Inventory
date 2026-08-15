package tn.ghassen.inventory.dto.PurchaseItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseItemResponseDTO(
        Long id,
        Long productId,
        Long rawMaterialId,
        Long purchaseId,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal totalPrice,
        BigDecimal discount,
        BigDecimal tax,
        BigDecimal subtotal,
        LocalDateTime createdAt
) {
}
