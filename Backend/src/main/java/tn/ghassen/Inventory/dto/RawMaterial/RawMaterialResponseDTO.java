package tn.ghassen.inventory.dto.RawMaterial;

import tn.ghassen.inventory.enums.RawMaterialStatus;
import tn.ghassen.inventory.enums.Unit;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RawMaterialResponseDTO(
        Long id,
        String name,
        String logo,
        BigDecimal costPrice,
        BigDecimal quantity,
        Unit unit,
        RawMaterialStatus status,
        Long companyId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
