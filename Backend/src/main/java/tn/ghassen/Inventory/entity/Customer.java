package tn.ghassen.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    private String taxNumber;

    private String address;

    private String logo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
