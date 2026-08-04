package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Formula;
import tn.ghassen.inventory.repository.FormulaRepository;
import tn.ghassen.inventory.service.FormulaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormulaServiceImpl implements FormulaService {

    private final FormulaRepository formulaRepository;

    @Override
    public Formula createFormula(Formula formula) {
        return formulaRepository.save(formula);
    }

    @Override
    public Formula getFormulaById(Long id) {
        return formulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formula not found"));
    }

    @Override
    public List<Formula> getAllFormulas() {
        return formulaRepository.findAll();
    }

    @Override
    public Formula updateFormula(Long id, Formula formula) {

        Formula existing = getFormulaById(id);

        existing.setProduct(formula.getProduct());

        return formulaRepository.save(existing);
    }

    @Override
    public void deleteFormula(Long id) {
        formulaRepository.deleteById(id);
    }
}