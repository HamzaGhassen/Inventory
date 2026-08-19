package tn.ghassen.inventory.dto.Sale;

import tn.ghassen.inventory.dto.Sale_Item.SaleItemUpdateDTO;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;

public record SaleUpdateDTO(
        Long customerId,
        Long userId,
        Long companyId,
        BigDecimal totalAmount,
        String description,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        List<SaleItemUpdateDTO> saleItems

) {
}
