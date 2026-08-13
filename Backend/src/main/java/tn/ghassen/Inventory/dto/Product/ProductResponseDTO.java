package tn.ghassen.inventory.dto.Product;

import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.enums.ProductType;
import tn.ghassen.inventory.enums.Unit;

import java.math.BigDecimal;

public record ProductResponseDTO(
        String name,
        String logo,
        BigDecimal costPrice,
        BigDecimal sellingPrice,
        BigDecimal quantity,
        ProductType productType,
        Unit unit,
        Long companyId,
        String companyName

) {
}
