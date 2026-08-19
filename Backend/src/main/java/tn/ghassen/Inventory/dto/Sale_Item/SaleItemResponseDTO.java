package tn.ghassen.inventory.dto.Sale_Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SaleItemResponseDTO(

        Long id,
        Long productId,
        Long saleId,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal totalPrice,
        BigDecimal discount,
        BigDecimal tax,
        BigDecimal subtotal,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
