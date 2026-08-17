package tn.ghassen.inventory.dto.FormulaItem;

import java.math.BigDecimal;

public record FormulaItemCreateDTO(
        Long rawMaterialId,
        BigDecimal quantity
) {
}
