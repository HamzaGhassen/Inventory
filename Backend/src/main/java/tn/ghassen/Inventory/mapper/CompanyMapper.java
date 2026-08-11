package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.company.CompanyCreateDTO;
import tn.ghassen.inventory.dto.company.CompanyResponseDTO;
import tn.ghassen.inventory.dto.company.CompanyUpdateDTO;
import tn.ghassen.inventory.entity.Company;

@Component
public class CompanyMapper {

    public Company toEntity(CompanyCreateDTO dto) {
        Company company = new Company();

        company.setName(dto.getName());
        company.setEmail(dto.getEmail());
        company.setPhone(dto.getPhone());
        company.setAddress(dto.getAddress());
        company.setTaxNumber(dto.getTaxNumber());
        company.setLogo(dto.getLogo());

        return company;
    }

    public CompanyResponseDTO toResponseDTO(Company company) {
        CompanyResponseDTO dto = new CompanyResponseDTO();

        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setEmail(company.getEmail());
        dto.setPhone(company.getEmail());
        dto.setTaxNumber(company.getTaxNumber());
        dto.setLogo(company.getLogo());

        return dto;

    }

    public void updateEntity(Company company, CompanyUpdateDTO dto) {

        company.setName(dto.getName());
        company.setEmail(dto.getEmail());
        company.setPhone(dto.getPhone());
        company.setAddress(dto.getAddress());
        company.setTaxNumber(dto.getTaxNumber());
        company.setLogo(dto.getLogo());
    }
}
