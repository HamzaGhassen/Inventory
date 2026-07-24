package tn.ghassen.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.ghassen.inventory.enums.RawMaterialStatus;
import tn.ghassen.inventory.enums.Unit;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "raw_materials")
@Getter
@Setter
public class RawMaterial extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String logo;

    @Column(nullable = false)
    private BigDecimal costPrice;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RawMaterialStatus status;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
