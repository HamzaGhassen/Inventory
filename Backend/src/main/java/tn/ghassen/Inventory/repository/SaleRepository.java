package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}