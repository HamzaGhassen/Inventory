package tn.ghassen.inventory.dto.Purchase;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;

public record PurchaseCreateDTO(
        Long supplierId,
        Long userId,
        Long companyId,
        BigDecimal totalAmount,
        String description,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod
) {


}
