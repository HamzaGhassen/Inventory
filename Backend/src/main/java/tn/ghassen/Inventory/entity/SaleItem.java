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
@Table(name = "sale_items")
public class SaleItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name ="sale_id",nullable = false)
    private Sale sale;

    @Column(nullable = false)
    private BigDecimal quantity;

    // Stores the product selling price at the time of the sale.    @Column(nullable = false)
    private BigDecimal unitPrice;
    // Total amount = quantity × unitPrice.    @Column(nullable = false)
    private BigDecimal totalPrice;

    private BigDecimal discount;

    private BigDecimal tax;

    private BigDecimal subtotal;
}
