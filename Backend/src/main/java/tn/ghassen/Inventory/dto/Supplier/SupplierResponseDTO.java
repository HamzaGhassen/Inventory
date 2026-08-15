package tn.ghassen.inventory.dto.Supplier;

public record SupplierResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String address,
        String taxNumber,
        String logo,
        Long companyId
) {
}
