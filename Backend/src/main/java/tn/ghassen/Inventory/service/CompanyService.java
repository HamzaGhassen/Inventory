package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.company.CompanyCreateDTO;
import tn.ghassen.inventory.dto.company.CompanyResponseDTO;
import tn.ghassen.inventory.dto.company.CompanyUpdateDTO;
import tn.ghassen.inventory.entity.Company;

import java.util.List;

public interface CompanyService {

    CompanyResponseDTO createCompany(CompanyCreateDTO dto);

    CompanyResponseDTO getCompanyById(Long id);

    List<CompanyResponseDTO> getAllCompanies();

    CompanyResponseDTO updateCompany(Long id, CompanyUpdateDTO dto);

    void deleteCompany(Long id);
}