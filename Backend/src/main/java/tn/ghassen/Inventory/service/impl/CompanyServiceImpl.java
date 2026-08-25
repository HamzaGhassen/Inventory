package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.company.CompanyCreateDTO;
import tn.ghassen.inventory.dto.company.CompanyResponseDTO;
import tn.ghassen.inventory.dto.company.CompanyUpdateDTO;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.mapper.CompanyMapper;
import tn.ghassen.inventory.repository.CompanyRepository;
import tn.ghassen.inventory.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponseDTO createCompany(CompanyCreateDTO dto) {
            Company company = companyMapper.toEntity(dto);

            Company savedCompany = companyRepository.save(company);
        return companyMapper.toResponseDTO(savedCompany);
    }

    @Override
    public CompanyResponseDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id "+ id));

        return companyMapper.toResponseDTO(company);
    }

    @Override
    public List<CompanyResponseDTO> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(companyMapper::toResponseDTO)
                .toList();
    }

    @Override
    public CompanyResponseDTO updateCompany(Long id, CompanyUpdateDTO dto) {

        Company existing = companyRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Company not found with id "+id));
        companyMapper.updateEntity(existing, dto);
        Company updatedCompany = companyRepository.save(existing);


        return companyMapper.toResponseDTO(updatedCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("company not found with id :" + id);
        }
        companyRepository.deleteById(id);
    }
}