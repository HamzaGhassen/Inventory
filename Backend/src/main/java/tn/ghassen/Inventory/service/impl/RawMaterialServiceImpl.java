package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialCreateDTO;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialResponseDTO;
import tn.ghassen.inventory.dto.RawMaterial.RawMaterialUpdateDTO;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.entity.RawMaterial;
import tn.ghassen.inventory.mapper.RawMaterialMapper;
import tn.ghassen.inventory.repository.CompanyRepository;
import tn.ghassen.inventory.repository.RawMaterialRepository;
import tn.ghassen.inventory.service.RawMaterialService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RawMaterialServiceImpl implements RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;
    private final CompanyRepository companyRepository;
    private final RawMaterialMapper rawMaterialMapper;

    @Override
    public RawMaterialResponseDTO createRawMaterial(RawMaterialCreateDTO dto) {
        Company company = companyRepository.findById(dto.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.companyId()));

        RawMaterial rawMaterial = rawMaterialMapper.toEntity(dto);
        rawMaterial.setCompany(company);

        RawMaterial savedRawMaterial = rawMaterialRepository.save(rawMaterial);
        return rawMaterialMapper.toResponse(savedRawMaterial);
    }

    @Override
    public RawMaterialResponseDTO getRawMaterialById(Long id) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found with id: " + id));
        return rawMaterialMapper.toResponse(rawMaterial);
    }

    @Override
    public List<RawMaterialResponseDTO> getAllRawMaterials() {
        return rawMaterialRepository.findAll()
                .stream()
                .map(rawMaterialMapper::toResponse)
                .toList();
    }

    @Override
    public RawMaterialResponseDTO updateRawMaterial(Long id, RawMaterialUpdateDTO dto) {
        RawMaterial existing = rawMaterialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found with id: " + id));

        if (dto.companyId() != null) {
            Company company = companyRepository.findById(dto.companyId())
                    .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.companyId()));
            existing.setCompany(company);
        }

        rawMaterialMapper.updateEntity(existing, dto);

        RawMaterial updatedRawMaterial = rawMaterialRepository.save(existing);
        return rawMaterialMapper.toResponse(updatedRawMaterial);
    }

    @Override
    public void deleteRawMaterial(Long id) {
        if (!rawMaterialRepository.existsById(id)) {
            throw new RuntimeException("Raw material not found with id: " + id);
        }
        rawMaterialRepository.deleteById(id);
    }
}
