package tn.ghassen.inventory.dto.Formula;

import tn.ghassen.inventory.dto.FormulaItem.FormulaItemResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record FormulaResponseDTO(
        Long id,
        Long productId,
        String productName,
        List<FormulaItemResponseDTO> formulaItems,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
