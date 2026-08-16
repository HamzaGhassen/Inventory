package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialCreateDTO;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialResponseDTO;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialUpdateDTO;
import tn.ghassen.inventory.entity.RawMaterial;

@Component
public class RawMaterialMapper {
    public RawMaterial toEntity(RawMaterialCreateDTO dto){

        RawMaterial rawMaterial = new RawMaterial();

        rawMaterial.setName(dto.name());
        rawMaterial.setLogo(dto.logo());
        rawMaterial.setQuantity(dto.quantity());
        rawMaterial.setCostPrice(dto.costPrice());
        rawMaterial.setUnit(dto.unit());
        rawMaterial.setStatus(dto.status());

        return rawMaterial;


    }

public RawMaterialResponseDTO toResponse(RawMaterial raw){
        return new RawMaterialResponseDTO(
                raw.getName(),
                raw.getLogo(),
                raw.getCostPrice(),
                raw.getQuantity(),
                raw.getUnit(),
                raw.getStatus(),
                raw.getCompany() != null ? raw.getCompany().getId() : null ,
                raw.getCreatedAt(),
                raw.getUpdatedAt()
        );
}

public void UpdateEntity(RawMaterial raw , RawMaterialUpdateDTO dto){

        if (dto.name() != null) {
            raw.setName(dto.name());
        }
        if (dto.logo() != null){
            raw.setLogo(dto.logo());
        }
        if (dto.costPrice() != null){
            raw.setCostPrice(dto.costPrice());
        }
        if (dto.quantity() != null){
            raw.setQuantity(dto.quantity());
        }
        if (dto.unit() != null){
            raw.setUnit(dto.unit());
        }
        if (dto.status() != null){
            raw.setStatus(dto.status());
        }
}
}
