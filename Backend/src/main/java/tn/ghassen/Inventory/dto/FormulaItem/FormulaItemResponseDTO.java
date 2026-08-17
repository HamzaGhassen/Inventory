package tn.ghassen.inventory.dto.FormulaItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FormulaItemResponseDTO(
        Long id,
        Long rawMaterialId,
        String rawMaterialName,
        Long formulaId,
        BigDecimal quantity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
