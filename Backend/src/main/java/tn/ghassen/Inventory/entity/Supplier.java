package tn.ghassen.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier extends BusinessPartner {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
