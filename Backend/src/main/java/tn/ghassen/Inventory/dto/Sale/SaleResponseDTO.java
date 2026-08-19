package tn.ghassen.inventory.dto.Sale;

import tn.ghassen.inventory.dto.Sale_Item.SaleItemCreateDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemResponseDTO;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponseDTO(
        Long id,
        Long customerId,
        Long userId,
        Long companyId,
        String description,
        BigDecimal totalAmount,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        List<SaleItemResponseDTO> saleItems,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
