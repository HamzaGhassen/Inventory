package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemResponseDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseCreateDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseResponseDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseUpdateDTO;
import tn.ghassen.inventory.entity.Purchase;

import java.util.Collections;
import java.util.List;

@Component
public class PurchaseMapper {

private final PurchaseItemMapper purchaseItemMapper;
    public PurchaseMapper(PurchaseItemMapper purchaseItemMapper) {
        this.purchaseItemMapper = purchaseItemMapper;
    }

    public Purchase toEntity(PurchaseCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        Purchase purchase = new Purchase();

        purchase.setTotalAmount(dto.totalAmount());
        purchase.setPaymentStatus(dto.paymentStatus());
        purchase.setPaymentMethod(dto.paymentMethod());

        return purchase;
    }

    public void updateEntity(Purchase purchase, PurchaseUpdateDTO dto) {
        if (dto.paymentStatus() != null) {
            purchase.setPaymentStatus(dto.paymentStatus());
        }
        if (dto.paymentMethod() != null) {
            purchase.setPaymentMethod(dto.paymentMethod());
        }
    }

    public PurchaseResponseDTO toResponseDTO(Purchase purchase) {
        List<PurchaseItemResponseDTO> items = purchase.getPurchaseItems() != null
                ? purchase.getPurchaseItems().stream()
                .map(purchaseItemMapper::toResponseDTO)
                .toList()
                : Collections.emptyList();
        return new PurchaseResponseDTO(
                purchase.getId(),
                purchase.getSupplier() != null ? purchase.getSupplier().getId() : null,
                purchase.getUser() != null ? purchase.getUser().getId(): null,
                purchase.getCompany() != null ? purchase.getCompany().getId():null,
                purchase.getTotalAmount(),
                items,
                purchase.getPaymentStatus(),
                purchase.getPaymentMethod(),
                purchase.getCreatedAt()
        );
    }
    public  PurchaseResponseDTO toResponse(Purchase purchase){return toResponseDTO(purchase);}
}