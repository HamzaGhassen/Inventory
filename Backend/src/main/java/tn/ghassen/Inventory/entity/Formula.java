package tn.ghassen.inventory.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "formulas")
public class Formula extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "formula")
    private List<FormulaItem> formulaItems = new ArrayList<>();

    @OneToMany(mappedBy = "formula")
    private List<StockMovement> stockMovements;
}
