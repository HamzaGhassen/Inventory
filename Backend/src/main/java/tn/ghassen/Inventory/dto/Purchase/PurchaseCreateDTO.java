package tn.ghassen.inventory.dto.Purchase;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemCreateDTO;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;

public record PurchaseCreateDTO(
        Long supplierId,
        Long userId,
        Long companyId,
        BigDecimal totalAmount,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        List<PurchaseItemCreateDTO> purchaseItems
) {


}
