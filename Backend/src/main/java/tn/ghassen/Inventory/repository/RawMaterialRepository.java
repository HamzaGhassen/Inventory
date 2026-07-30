package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.RawMaterial;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
}