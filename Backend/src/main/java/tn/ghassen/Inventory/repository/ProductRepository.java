package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}