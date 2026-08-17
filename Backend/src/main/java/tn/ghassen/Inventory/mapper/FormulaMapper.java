package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Formula.FormulaCreateDTO;
import tn.ghassen.inventory.dto.Formula.FormulaResponseDTO;
import tn.ghassen.inventory.dto.Formula.FormulaUpdateDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemResponseDTO;
import tn.ghassen.inventory.entity.Formula;

import java.util.Collections;
import java.util.List;

@Component
public class FormulaMapper {

    private final FormulaItemMapper formulaItemMapper;

    public FormulaMapper(FormulaItemMapper formulaItemMapper) {
        this.formulaItemMapper = formulaItemMapper;
    }

    public Formula toEntity(FormulaCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        Formula formula = new Formula();
        return formula;
    }

    public FormulaResponseDTO toResponseDTO(Formula formula) {
        if (formula == null) {
            return null;
        }
        List<FormulaItemResponseDTO> items = formula.getFormulaItems() != null
                ? formula.getFormulaItems().stream()
                        .map(formulaItemMapper::toResponseDTO)
                        .toList()
                : Collections.emptyList();


        return new FormulaResponseDTO(
                formula.getId(),
                formula.getProduct() != null ? formula.getProduct().getId() : null,
                formula.getProduct() != null ? formula.getProduct().getName() : null,
                items,
                formula.getCreatedAt(),
                formula.getUpdatedAt()
        );
    }

    public FormulaResponseDTO toResponse(Formula formula) {
        return toResponseDTO(formula);
    }

    public void updateEntity(Formula formula, FormulaUpdateDTO dto) {
        if (formula == null || dto == null) {
            return;
        }
    }
}
