package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.repository.CompanyRepository;
import tn.ghassen.inventory.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company company) {

        Company existing = getCompanyById(id);

        existing.setName(company.getName());
        existing.setEmail(company.getEmail());
        existing.setPhone(company.getPhone());
        existing.setAddress(company.getAddress());
        existing.setTaxNumber(company.getTaxNumber());
        existing.setLogo(company.getLogo());

        return companyRepository.save(existing);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}