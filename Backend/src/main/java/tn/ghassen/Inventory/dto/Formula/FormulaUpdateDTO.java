package tn.ghassen.inventory.dto.Formula;

import tn.ghassen.inventory.dto.FormulaItem.FormulaItemUpdateDTO;

import java.util.List;

public record FormulaUpdateDTO(
        Long productId,
        List<FormulaItemUpdateDTO> formulaItems
) {
}
