package tn.ghassen.inventory.dto.StockMovement;

import tn.ghassen.inventory.enums.StockAction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record StockMovementResponseDTO(
        Long id,
        BigDecimal quantity,
        StockAction action,
        String description,
        Long userId,
        Long companyId,
        Long productId,
        Long rawMaterialId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
