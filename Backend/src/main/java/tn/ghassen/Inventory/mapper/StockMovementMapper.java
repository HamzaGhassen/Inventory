package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.StockMovement.StockMovementCreateDTO;
import tn.ghassen.inventory.dto.StockMovement.StockMovementResponseDTO;
import tn.ghassen.inventory.dto.StockMovement.StockMovementUpdateDTO;
import tn.ghassen.inventory.entity.StockMovement;

@Component
public class StockMovementMapper {

    public StockMovement toEntity(StockMovementCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        StockMovement stockMovement = new StockMovement();
        stockMovement.setQuantity(dto.quantity());
        stockMovement.setAction(dto.action());
        stockMovement.setDescription(dto.description());

        return stockMovement;
    }

    public StockMovementResponseDTO toResponseDTO(StockMovement stockMovement) {
        if (stockMovement == null) {
            return null;
        }

        return new StockMovementResponseDTO(
                stockMovement.getId(),
                stockMovement.getQuantity(),
                stockMovement.getAction(),
                stockMovement.getDescription(),
                stockMovement.getUser() != null ? stockMovement.getUser().getId() : null,
                stockMovement.getCompany() != null ? stockMovement.getCompany().getId() : null,
                stockMovement.getProduct() != null ? stockMovement.getProduct().getId() : null,
                stockMovement.getRawMaterial() != null ? stockMovement.getRawMaterial().getId() : null,
                stockMovement.getCreatedAt(),
                stockMovement.getUpdatedAt()
        );
    }

    public StockMovementResponseDTO toResponse(StockMovement stockMovement) {
        return toResponseDTO(stockMovement);
    }

    public void updateEntity(StockMovement stockMovement, StockMovementUpdateDTO dto) {
        if (stockMovement == null || dto == null) {
            return;
        }

        if (dto.quantity() != null) {
            stockMovement.setQuantity(dto.quantity());
        }
        if (dto.action() != null) {
            stockMovement.setAction(dto.action());
        }
        if (dto.description() != null) {
            stockMovement.setDescription(dto.description());
        }
    }
}
