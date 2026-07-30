package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.FinancialTransaction;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
}