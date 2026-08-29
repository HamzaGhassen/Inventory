package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.Formula.FormulaCreateDTO;
import tn.ghassen.inventory.dto.Formula.FormulaResponseDTO;
import tn.ghassen.inventory.dto.Formula.FormulaUpdateDTO;
import tn.ghassen.inventory.entity.Formula;
import tn.ghassen.inventory.mapper.FormulaMapper;
import tn.ghassen.inventory.repository.FormulaRepository;
import tn.ghassen.inventory.service.FormulaService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FormulaServiceImpl implements FormulaService {

    private final FormulaRepository formulaRepository;
    private final FormulaMapper formulaMapper;

    @Override
    public FormulaResponseDTO createFormula(FormulaCreateDTO dto) {
        if (dto.productId() == null){
            throw new RuntimeException("there is no product");
        }
        else if(dto.formulaItems()==null) {
            throw new RuntimeException("there is no items");
        }
        Formula formula = formulaMapper.toEntity(dto);

        Formula savedFormula = formulaRepository.save(formula);

        return formulaMapper.toResponse(savedFormula);
    }

    @Override
    public FormulaResponseDTO getFormulaById(Long id) {
        Formula formula =formulaRepository.findById(id)
              .orElseThrow(()->new RuntimeException("there is no formula with this id"+id));
      return formulaMapper.toResponse(formula);
    }

    @Override
    public List<FormulaResponseDTO> getAllFormulas() {
        return formulaRepository.findAll()
                .stream()
                .map(formulaMapper::toResponse)
                .toList();
    }

    @Override
    public FormulaResponseDTO updateFormula(Long id, FormulaUpdateDTO dto) {

        Formula existing = formulaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("There is no formula with this id: " + id)
                );

        formulaMapper.updateEntity(existing, dto);
        Formula updatedFormula = formulaRepository.save(existing);
        return formulaMapper.toResponse(updatedFormula);
    }

    @Override
    public void deleteFormula(Long id) {

        Formula existing = formulaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("There is no formula with this id: " + id)
                );
        formulaRepository.delete(existing);
    }
}