package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemCreateDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemResponseDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemUpdateDTO;
import tn.ghassen.inventory.entity.PurchaseItem;

import java.math.BigDecimal;

@Component
public class PurchaseItemMapper {

    public PurchaseItem toEntity(PurchaseItemCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        PurchaseItem item = new PurchaseItem();
        item.setQuantity(dto.quantity());
        item.setUnitPrice(dto.unitPrice());
        item.setDiscount(dto.discount());
        item.setTax(dto.tax());

        BigDecimal qty = dto.quantity() != null ? dto.quantity() : BigDecimal.ZERO;
        BigDecimal price = dto.unitPrice() != null ? dto.unitPrice() : BigDecimal.ZERO;
        BigDecimal total = qty.multiply(price);
        item.setTotalPrice(total);

        BigDecimal discount = dto.discount() != null ? dto.discount() : BigDecimal.ZERO;
        BigDecimal tax = dto.tax() != null ? dto.tax() : BigDecimal.ZERO;
        item.setSubtotal(total.subtract(discount).add(tax));

        return item;
    }

    public void updateEntity(PurchaseItem item, PurchaseItemUpdateDTO dto) {
        if (item == null || dto == null) {
            return;
        }
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
        if (dto.totalPrice() != null) {
            item.setTotalPrice(dto.totalPrice());
        } else if (dto.quantity() != null || dto.unitPrice() != null) {
            BigDecimal qty = item.getQuantity() != null ? item.getQuantity() : BigDecimal.ZERO;
            BigDecimal price = item.getUnitPrice() != null ? item.getUnitPrice() : BigDecimal.ZERO;
            item.setTotalPrice(qty.multiply(price));
        }
        if (dto.subtotal() != null) {
            item.setSubtotal(dto.subtotal());
        } else if (item.getTotalPrice() != null) {
            BigDecimal total = item.getTotalPrice();
            BigDecimal discount = item.getDiscount() != null ? item.getDiscount() : BigDecimal.ZERO;
            BigDecimal tax = item.getTax() != null ? item.getTax() : BigDecimal.ZERO;
            item.setSubtotal(total.subtract(discount).add(tax));
        }
    }

    public PurchaseItemResponseDTO toResponseDTO(PurchaseItem item) {
        if (item == null) {
            return null;
        }
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

    public PurchaseItemResponseDTO toResponse(PurchaseItem item) {
        return toResponseDTO(item);
    }
}
