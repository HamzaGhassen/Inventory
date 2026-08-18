package tn.ghassen.inventory.dto.StockMovement;

import tn.ghassen.inventory.enums.StockAction;

import java.math.BigDecimal;

public record StockMovementCreateDTO(
        BigDecimal quantity,
        StockAction action,
        String description,
        Long userId,
        Long companyId,
        Long productId,
        Long rawMaterialId
) {
}
