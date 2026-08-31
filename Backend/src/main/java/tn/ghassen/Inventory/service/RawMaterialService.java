package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.RawMaterial.RawMaterialCreateDTO;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialResponseDTO;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialUpdateDTO;

import java.util.List;

public interface RawMaterialService {

    RawMaterialResponseDTO createRawMaterial(RawMaterialCreateDTO dto);

    RawMaterialResponseDTO getRawMaterialById(Long id);

    List<RawMaterialResponseDTO> getAllRawMaterials();

    RawMaterialResponseDTO updateRawMaterial(Long id, RawMaterialUpdateDTO dto);

    void deleteRawMaterial(Long id);

}
