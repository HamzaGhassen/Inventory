package tn.ghassen.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.ghassen.inventory.enums.ProductType;
import tn.ghassen.inventory.enums.Unit;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String logo;
    @Column(nullable = false)
    private BigDecimal costPrice;
    @Column(nullable = false)
    private BigDecimal sellingPrice;
    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
