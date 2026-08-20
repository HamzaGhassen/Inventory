package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Sale.SaleCreateDTO;
import tn.ghassen.inventory.dto.Sale.SaleResponseDTO;
import tn.ghassen.inventory.dto.Sale.SaleUpdateDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemResponseDTO;
import tn.ghassen.inventory.entity.Sale;

import java.util.Collections;
import java.util.List;


@Component
public class SaleMapper {

    private final SaleItemMapper saleItemMapper;

    public SaleMapper(SaleItemMapper saleItemMapper){
        this.saleItemMapper = saleItemMapper;
    }

    public Sale toEntity(SaleCreateDTO dto){
        if (dto == null){
            return null;
        }
        Sale sale = new Sale();

        sale.setDescription(dto.description());
        sale.setPaymentStatus(dto.paymentStatus());
        sale.setPaymentMethod(dto.paymentMethod());

        return sale;
    }

    public void updateEntity(Sale sale , SaleUpdateDTO dto) {
        if (dto.totalAmount() != null){
            sale.setTotalAmount(dto.totalAmount());
        }
        if (dto.description()!= null){
            sale.setDescription(dto.description());
        }

        if (dto.paymentStatus()!=null){
            sale.setPaymentStatus(dto.paymentStatus());
        }
        if (dto.paymentMethod()!=null){
            sale.setPaymentMethod(dto.paymentMethod());
        }
    }

    public SaleResponseDTO toResponseDTO(Sale sale){
        List< SaleItemResponseDTO> items = sale.getSaleItems() != null
            ? sale.getSaleItems().stream()
              .map(saleItemMapper::toResponseDTO)
              .toList()
                : Collections.emptyList();
        return new SaleResponseDTO(
                sale.getId(),
                sale.getCustomer() != null ? sale.getCustomer().getId() : null,
                sale.getUser() != null ? sale.getUser().getId() : null ,
                sale.getCompany() != null ? sale.getCompany().getId() : null,
                sale.getDescription(),
                sale.getTotalAmount(),
                sale.getPaymentStatus(),
                sale.getPaymentMethod(),
                items,
                sale.getCreatedAt(),
                sale.getUpdatedAt()
                );
    }
}
