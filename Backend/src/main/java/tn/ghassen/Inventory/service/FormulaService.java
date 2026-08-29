package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.Formula.FormulaCreateDTO;
import tn.ghassen.inventory.dto.Formula.FormulaResponseDTO;
import tn.ghassen.inventory.dto.Formula.FormulaUpdateDTO;
import tn.ghassen.inventory.entity.Formula;

import java.util.List;

public interface FormulaService {

    FormulaResponseDTO createFormula(FormulaCreateDTO dto);

    FormulaResponseDTO getFormulaById(Long id);

    List<FormulaResponseDTO> getAllFormulas();

    FormulaResponseDTO updateFormula(Long id, FormulaUpdateDTO dto);

    void deleteFormula(Long id);
}