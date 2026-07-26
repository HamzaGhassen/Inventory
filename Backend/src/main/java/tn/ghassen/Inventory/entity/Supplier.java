package tn.ghassen.inventory.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier extends BusinessPartner {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchases = new ArrayList<>();

}
