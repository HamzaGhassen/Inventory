package tn.ghassen.inventory.dto.PurchaseItem;

import java.math.BigDecimal;

public record PurchaseItemCreateDTO(
        Long productId,
        Long rawMaterialId,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal discount,
        BigDecimal tax

) {
}
