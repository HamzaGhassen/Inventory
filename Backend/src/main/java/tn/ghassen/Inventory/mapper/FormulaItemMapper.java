package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemCreateDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemResponseDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemUpdateDTO;
import tn.ghassen.inventory.entity.FormulaItem;

@Component
public class FormulaItemMapper {

    public FormulaItem toEntity(FormulaItemCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        FormulaItem item = new FormulaItem();
        item.setQuantity(dto.quantity());
        return item;
    }

    public FormulaItemResponseDTO toResponseDTO(FormulaItem item) {
        if (item == null) {
            return null;
        }
        return new FormulaItemResponseDTO(
                item.getId(),
                item.getRawMaterial() != null ? item.getRawMaterial().getId() : null,
                item.getRawMaterial() != null ? item.getRawMaterial().getName() : null,
                item.getFormula() != null ? item.getFormula().getId() : null,
                item.getQuantity(),
                item.getCreatedAt(),
                item.getUpdatedAt()
        );
    }

    public FormulaItemResponseDTO toResponse(FormulaItem item) {
        return toResponseDTO(item);
    }

    public void updateEntity(FormulaItem item, FormulaItemUpdateDTO dto) {
        if (item == null || dto == null) {
            return;
        }
        if (dto.quantity() != null) {
            item.setQuantity(dto.quantity());
        }
    }
}
