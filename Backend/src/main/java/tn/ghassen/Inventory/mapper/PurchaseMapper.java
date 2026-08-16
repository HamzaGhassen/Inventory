package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Purchase.PurchaseCreateDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseResponseDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseUpdateDTO;
import tn.ghassen.inventory.entity.Purchase;

@Component
public class PurchaseMapper {

    public Purchase toEntity(PurchaseCreateDTO dto) {

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

        return new PurchaseResponseDTO(
                purchase.getId(),
                purchase.getSupplier().getId(),
                purchase.getUser().getId(),
                purchase.getCompany().getId(),
                purchase.getTotalAmount(),
                purchase.getPaymentStatus(),
                purchase.getPaymentMethod(),
                purchase.getCreatedAt()
        );
    }
}