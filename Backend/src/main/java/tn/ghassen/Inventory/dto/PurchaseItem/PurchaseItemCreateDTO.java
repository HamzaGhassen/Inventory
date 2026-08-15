package tn.ghassen.inventory.dto.PurchaseItem;

import java.math.BigDecimal;

public record PurchaseItemCreateDTO(
        Long productId,
        Long rawMaterialId,
        Long purchaseId,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal totalPrice,
        BigDecimal discount,
        BigDecimal tax,
        BigDecimal subtotal
) {
}
