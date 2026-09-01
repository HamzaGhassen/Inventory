package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Expense;
import tn.ghassen.inventory.entity.SaleItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
    Optional<SaleItem> findByIdAndSaleCompanyId(Long id, Long companyId);
    List<SaleItem> findBySaleCompanyId(Long id);

    boolean existsByIdAndSaleCompanyId(Long id, Long companyId);}