package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.PurchaseItem;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
}