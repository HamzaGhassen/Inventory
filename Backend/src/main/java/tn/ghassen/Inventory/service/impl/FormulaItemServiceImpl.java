package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.FormulaItem;
import tn.ghassen.inventory.repository.FormulaItemRepository;
import tn.ghassen.inventory.service.FormulaItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormulaItemServiceImpl implements FormulaItemService {

    private final FormulaItemRepository formulaItemRepository;

    @Override
    public FormulaItem createFormulaItem(FormulaItem formulaItem) {
        return formulaItemRepository.save(formulaItem);
    }

    @Override
    public FormulaItem getFormulaItemById(Long id) {
        return formulaItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Formula_item not found"));
    }

    @Override
    public List<FormulaItem> getAllFormulaItem() {
        return formulaItemRepository.findAll();
    }

    @Override
    public FormulaItem updateFormulaItem(Long id, FormulaItem formulaItem) {
        FormulaItem existing = getFormulaItemById(id);

        existing.setQuantity(formulaItem.getQuantity());
        existing.setFormula(formulaItem.getFormula());
        existing.setRawMaterial(formulaItem.getRawMaterial());
        return formulaItemRepository.save(existing);
    }

    @Override
    public void deleteFormulaItem(Long id) {
        formulaItemRepository.deleteById(id);
    }
}
