package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Supplier.SupplierCreateDTO;
import tn.ghassen.inventory.dto.Supplier.SupplierResponseDTO;
import tn.ghassen.inventory.dto.Supplier.SupplierUpdateDTO;
import tn.ghassen.inventory.entity.Supplier;

@Component
public class SupplierMapper {
    public Supplier toEntity(SupplierCreateDTO dto){
        Supplier supplier = new Supplier();

        supplier.setName(dto.name());
        supplier.setEmail(dto.email());
        supplier.setPhone(dto.phone());
        supplier.setAddress(dto.address());
        supplier.setTaxNumber(dto.taxNumber());
        supplier.setLogo(dto.logo());
        return supplier;
    }

    public SupplierResponseDTO toResponse(Supplier supplier) {
        return new SupplierResponseDTO(
                supplier.getId(),
                supplier.getName(),
                supplier.getEmail(),
                supplier.getPhone(),
                supplier.getAddress(),
                supplier.getTaxNumber(),
                supplier.getLogo(),
                supplier.getCompany().getId()

        );

    }
    public void updateEntity(Supplier supplier, SupplierUpdateDTO dto) {

        if (dto.name() != null) {
            supplier.setName(dto.name());
        }

        if (dto.email() != null) {
            supplier.setEmail(dto.email());
        }

        if (dto.phone() != null) {
            supplier.setPhone(dto.phone());
        }

        if (dto.address() != null) {
            supplier.setAddress(dto.address());
        }

        if (dto.taxNumber() != null) {
            supplier.setTaxNumber(dto.taxNumber());
        }

        if (dto.logo() != null) {
            supplier.setLogo(dto.logo());
        }
    }

}
