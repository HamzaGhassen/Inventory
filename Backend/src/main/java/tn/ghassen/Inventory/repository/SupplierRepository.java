package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}