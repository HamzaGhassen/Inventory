package tn.ghassen.inventory.dto.Purchase;

import tn.ghassen.inventory.enums.PaymentMethod;
import tn.ghassen.inventory.enums.PaymentStatus;

import java.math.BigDecimal;

public record PurchaseUpdateDTO (
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod
){
}
