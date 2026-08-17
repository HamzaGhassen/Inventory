package tn.ghassen.inventory.dto.FormulaItem;

import java.math.BigDecimal;

public record FormulaItemUpdateDTO(
        Long rawMaterialId,
        Long formulaId,
        BigDecimal quantity
) {
}
