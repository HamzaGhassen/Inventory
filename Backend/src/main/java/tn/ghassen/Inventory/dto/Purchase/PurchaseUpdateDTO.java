package tn.ghassen.inventory.dto.Purchase;

import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemUpdateDTO;
import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.util.List;

public record PurchaseUpdateDTO (
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        List<PurchaseItemUpdateDTO> purchaseItems
){
}
