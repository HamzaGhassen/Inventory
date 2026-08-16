package tn.ghassen.inventory.dto.RawMaterial;

import tn.ghassen.inventory.enums.RawMaterialStatus;
import tn.ghassen.inventory.enums.Unit;

import java.math.BigDecimal;

public record RawMaterialUpdateDTO(
        String name,
        String logo,
        BigDecimal costPrice,
        BigDecimal quantity,
        Unit unit,
        RawMaterialStatus status
) {
}
