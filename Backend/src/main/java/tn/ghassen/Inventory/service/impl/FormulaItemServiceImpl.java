package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemCreateDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemResponseDTO;
import tn.ghassen.inventory.dto.FormulaItem.FormulaItemUpdateDTO;
import tn.ghassen.inventory.entity.Formula;
import tn.ghassen.inventory.entity.FormulaItem;
import tn.ghassen.inventory.entity.RawMaterial;
import tn.ghassen.inventory.mapper.FormulaItemMapper;
import tn.ghassen.inventory.repository.FormulaItemRepository;
import tn.ghassen.inventory.repository.FormulaRepository;
import tn.ghassen.inventory.repository.RawMaterialRepository;
import tn.ghassen.inventory.service.FormulaItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormulaItemServiceImpl implements FormulaItemService {

    private final FormulaItemRepository formulaItemRepository;
    private final FormulaRepository formulaRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final FormulaItemMapper formulaItemMapper;

    @Override
    public FormulaItemResponseDTO createFormulaItem(FormulaItemCreateDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("FormulaItemCreateDTO cannot be null");
        }

        FormulaItem formulaItem = formulaItemMapper.toEntity(dto);

        if (dto.rawMaterialId() != null) {
            RawMaterial rawMaterial = rawMaterialRepository.findById(dto.rawMaterialId())
                    .orElseThrow(() -> new RuntimeException("Raw material not found with id: " + dto.rawMaterialId()));
            formulaItem.setRawMaterial(rawMaterial);
        } else {
            throw new IllegalArgumentException("Raw material ID must be provided");
        }

        if (dto.formulaId() != null) {
            Formula formula = formulaRepository.findById(dto.formulaId())
                    .orElseThrow(() -> new RuntimeException("Formula not found with id: " + dto.formulaId()));
            formulaItem.setFormula(formula);
        } else {
            throw new IllegalArgumentException("Formula ID must be provided");
        }

        FormulaItem savedItem = formulaItemRepository.save(formulaItem);
        return formulaItemMapper.toResponseDTO(savedItem);
    }

    @Override
    public FormulaItemResponseDTO getFormulaItemById(Long id) {
        FormulaItem formulaItem = formulaItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formula item not found with id: " + id));
        return formulaItemMapper.toResponseDTO(formulaItem);
    }

    @Override
    public List<FormulaItemResponseDTO> getAllFormulaItems() {
        return formulaItemRepository.findAll()
                .stream()
                .map(formulaItemMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<FormulaItemResponseDTO> getFormulaItemsByFormulaId(Long formulaId) {
        return formulaItemRepository.findByFormulaId(formulaId)
                .stream()
                .map(formulaItemMapper::toResponseDTO)
                .toList();
    }

    @Override
    public FormulaItemResponseDTO updateFormulaItem(Long id, FormulaItemUpdateDTO dto) {
        FormulaItem existingItem = formulaItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formula item not found with id: " + id));

        if (dto.rawMaterialId() != null) {
            RawMaterial rawMaterial = rawMaterialRepository.findById(dto.rawMaterialId())
                    .orElseThrow(() -> new RuntimeException("Raw material not found with id: " + dto.rawMaterialId()));
            existingItem.setRawMaterial(rawMaterial);
        }

        if (dto.formulaId() != null) {
            Formula formula = formulaRepository.findById(dto.formulaId())
                    .orElseThrow(() -> new RuntimeException("Formula not found with id: " + dto.formulaId()));
            existingItem.setFormula(formula);
        }

        formulaItemMapper.updateEntity(existingItem, dto);

        FormulaItem updatedItem = formulaItemRepository.save(existingItem);
        return formulaItemMapper.toResponseDTO(updatedItem);
    }

    @Override
    public void deleteFormulaItem(Long id) {
        if (!formulaItemRepository.existsById(id)) {
            throw new RuntimeException("Formula item not found with id: " + id);
        }
        formulaItemRepository.deleteById(id);
    }
}
