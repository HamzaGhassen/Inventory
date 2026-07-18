package tn.ghassen.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.ghassen.inventory.enums.EmployeeStatus;
import tn.ghassen.inventory.enums.Role;

import java.time.LocalDateTime;
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

public class User {
// ID Annotation
    @Id
// Primary key generated automatically by PostgreSQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    // Employee first name (required)
    @Column(nullable = false)
    private String firstName;
    // Employee last name (required)
    @Column(nullable = false)
    private String lastName;
    // Employee email Unique
    @Column(unique = true)
    private String email;

    private String password;

    private String phone;
    @Column(nullable = false)
    // Employee's role inside the company
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = false)
    // Employee's status inside the company
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
