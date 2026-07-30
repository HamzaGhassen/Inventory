package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.FormulaItem;

@Repository
public interface FormulaItemRepository extends JpaRepository<FormulaItem, Long> {
}