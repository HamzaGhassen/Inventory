package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.FormulaItem.FormulaItemCreateDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemResponseDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemUpdateDTO;

import java.util.List;

public interface FormulaItemService {

    FormulaItemResponseDTO createFormulaItem(FormulaItemCreateDTO dto);

    FormulaItemResponseDTO getFormulaItemById(Long id);

    List<FormulaItemResponseDTO> getAllFormulaItems();

    List<FormulaItemResponseDTO> getFormulaItemsByFormulaId(Long formulaId);

    FormulaItemResponseDTO updateFormulaItem(Long id, FormulaItemUpdateDTO dto);

    void deleteFormulaItem(Long id);
}
