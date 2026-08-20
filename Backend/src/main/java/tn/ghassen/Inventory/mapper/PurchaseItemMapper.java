package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemCreateDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemResponseDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemUpdateDTO;
import tn.ghassen.inventory.entity.PurchaseItem;

@Component
public class PurchaseItemMapper {

    public PurchaseItem toEntity(PurchaseItemCreateDTO dto) {
        PurchaseItem item = new PurchaseItem();
        item.setQuantity(dto.quantity());
        item.setUnitPrice(dto.unitPrice());
        item.setDiscount(dto.discount());
        item.setTax(dto.tax());
        return item;
    }

    public void updateEntity(PurchaseItem item, PurchaseItemUpdateDTO dto) {
        if (dto.quantity() != null) {
            item.setQuantity(dto.quantity());
        }
        if (dto.unitPrice() != null) {
            item.setUnitPrice(dto.unitPrice());
        }

        if (dto.discount() != null) {
            item.setDiscount(dto.discount());
        }
        if (dto.tax() != null) {
            item.setTax(dto.tax());
        }

    }

    public PurchaseItemResponseDTO toResponseDTO(PurchaseItem item) {
        return new PurchaseItemResponseDTO(
                item.getId(),
                item.getProduct() != null ? item.getProduct().getId() : null,
                item.getRawMaterial() != null ? item.getRawMaterial().getId() : null,
                item.getPurchase() != null ? item.getPurchase().getId() : null,
                item.getQuantity(),
                item.getUnitPrice(),
                item.getTotalPrice(),
                item.getDiscount(),
                item.getTax(),
                item.getSubtotal(),
                item.getCreatedAt()
        );
    }
}
