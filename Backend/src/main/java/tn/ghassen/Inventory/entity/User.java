package tn.ghassen.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.ghassen.inventory.enums.Department;
import tn.ghassen.inventory.enums.EmployeeStatus;
import tn.ghassen.inventory.enums.Role;

// Lombok Getters and Setters
@Getter
@Setter
// Represents the "users" table in the database
@Entity
//JPA Annotation
@Table(name = "users")
// Constructor Lombok Annotation
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseEntity {

    // Employee first name (required)
    @Column(nullable = false)
    private String firstName;
    // Employee last name (required)
    @Column(nullable = false)
    private String lastName;
    // Employee email Unique and required
    @Column(nullable = false, unique = true)
    private String email;
    // Employee password (required)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    // Employee's role inside the company
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = false)

    // Employee's status inside the company
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    // Employee's department inside the company
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;


    // add foreign key
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
