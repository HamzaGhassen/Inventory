package tn.ghassen.inventory.dto.PurchaseItem;

import java.math.BigDecimal;

public record PurchaseItemUpdateDTO(
        Long productId,
        Long rawMaterialId,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal totalPrice,
        BigDecimal discount,
        BigDecimal tax,
        BigDecimal subtotal
) {
}
