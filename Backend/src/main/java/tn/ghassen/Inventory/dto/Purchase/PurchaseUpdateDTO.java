package tn.ghassen.inventory.dto.Purchase;

import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;

public record PurchaseUpdateDTO (
        String description,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod
){
}
