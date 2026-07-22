package tn.ghassen.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="companies")

@Entity
public class Company extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String taxNumber;

    private String logo;

    @OneToMany(mappedBy = "company")
    private List<User> users;

    @OneToMany (mappedBy ="company")
    private List<Customer> customers;

    @OneToMany (mappedBy="company")
    private List<Supplier> suppliers;

}

