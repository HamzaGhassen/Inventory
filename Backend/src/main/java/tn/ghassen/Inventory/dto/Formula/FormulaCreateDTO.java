package tn.ghassen.inventory.dto.Formula;

import tn.ghassen.inventory.dto.FormulaItem.FormulaItemCreateDTO;

import java.util.List;

public record FormulaCreateDTO(
        Long productId,
        List<FormulaItemCreateDTO> formulaItems
) {
}
