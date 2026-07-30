package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}