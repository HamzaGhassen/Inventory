package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Formula;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
}