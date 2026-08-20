package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemCreateDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemResponseDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemUpdateDTO;
import tn.ghassen.inventory.entity.SaleItem;


@Component
public class SaleItemMapper {
    public SaleItem toEntity(SaleItemCreateDTO dto){
        SaleItem item = new SaleItem();
        item.setQuantity(dto.quantity());
        item.setUnitPrice(dto.unitPrice());
        item.setDiscount(dto.discount());
        item.setTax(dto.tax());

        return item;
    }
    public void updateEntity(SaleItem item , SaleItemUpdateDTO dto){
        if (dto.quantity()!=null) {
            item.setQuantity(dto.quantity());
        }
        if (dto.unitPrice()!=null) {
            item.setUnitPrice(dto.unitPrice());
        }
        if(dto.discount()!=null) {
            item.setDiscount(dto.discount());
        }
        if (dto.tax()!=null) {
            item.setTax(dto.tax());
        }

    }
    public SaleItemResponseDTO toResponseDTO(SaleItem item){
        return  new SaleItemResponseDTO(
                item.getId(),
                item.getProduct()!=null ? item.getProduct().getId() : null,
                item.getSale()!=null ? item.getSale().getId() : null ,
                item.getQuantity(),
                item.getUnitPrice(),
                item.getTotalPrice(),
                item.getDiscount(),
                item.getTax(),
                item.getSubtotal(),
                item.getCreatedAt(),
                item.getUpdatedAt()
        );
    }
}
