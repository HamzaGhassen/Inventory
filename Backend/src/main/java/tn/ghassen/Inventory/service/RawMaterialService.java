package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.RawMaterial;

import java.util.List;

public interface RawMaterialService {

    RawMaterial createRawMaterial(RawMaterial rawMaterial);

    RawMaterial getRawMaterialById(Long id);

    List<RawMaterial> getAllRawMaterials();

    RawMaterial updateRawMaterial(Long id ,RawMaterial rawMaterial);

    void deleteRawMaterial(Long id);

}
