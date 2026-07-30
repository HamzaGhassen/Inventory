package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}