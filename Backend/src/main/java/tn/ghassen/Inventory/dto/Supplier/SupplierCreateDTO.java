package tn.ghassen.inventory.dto.Supplier;

import tn.ghassen.inventory.entity.Company;

public record SupplierCreateDTO(
        String name,
        String email,
        String phone,
        String address,
        String taxNumber,
        String logo,
        Long companyId
                                 ) {
}
