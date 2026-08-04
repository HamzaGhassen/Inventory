package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.Formula;

import java.util.List;

public interface FormulaService {

    Formula createFormula(Formula formula);

    Formula getFormulaById(Long id);

    List<Formula> getAllFormulas();

    Formula updateFormula(Long id, Formula formula);

    void deleteFormula(Long id);
}