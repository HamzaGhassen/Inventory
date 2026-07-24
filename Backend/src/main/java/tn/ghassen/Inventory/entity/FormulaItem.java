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
@Table(name ="formula_items")
public class FormulaItem extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "raw_material_id", nullable = false)
    private RawMaterial rawMaterial;

    @ManyToOne
    @JoinColumn(name = "formula_id",nullable = false)
    private Formula formula;

}
