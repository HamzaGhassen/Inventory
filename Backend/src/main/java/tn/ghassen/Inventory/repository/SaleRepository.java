package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Sale;

import java.util.Optional;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findByIdAndCompanyId(Long id, Long companyId);}