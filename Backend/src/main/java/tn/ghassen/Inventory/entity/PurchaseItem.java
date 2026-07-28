package tn.ghassen.inventory.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase_items")
public class PurchaseItem extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    
    @ManyToOne
    @JoinColumn(name = "rawmaterial_id")
    private RawMaterial rawMaterial;
    
    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;
    
    @Column(nullable = false)
    private BigDecimal quantity;

    // Stores the purchase price at the time of the purchase.
    @Column(nullable = false)
    private BigDecimal unitPrice;
    // Total amount = quantity × unitPrice.    @Column(nullable = false)
    private BigDecimal totalPrice;

    private BigDecimal discount;

    private BigDecimal tax;

    private BigDecimal subtotal;
    
}
