package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.FormulaItem;

import java.util.List;

public interface FormulaItemService {

    FormulaItem createFormulaItem(FormulaItem formulaItem);

    FormulaItem getFormulaItemById(Long id);

    List<FormulaItem> getAllFormulaItem();

    FormulaItem updateFormulaItem(Long id , FormulaItem formulaItem);

    void deleteFormulaItem(Long id);
}
