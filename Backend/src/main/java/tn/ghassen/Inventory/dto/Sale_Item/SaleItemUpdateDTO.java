package tn.ghassen.inventory.dto.Sale_Item;

import java.math.BigDecimal;

public record SaleItemUpdateDTO(

        Long productId,
        Long saleId,
        BigDecimal totalPrice,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal discount,
        BigDecimal tax,
        BigDecimal subtotal
) {
}
