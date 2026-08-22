package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.Customer.CustomerCreateDTO;
import tn.ghassen.inventory.dto.Customer.CustomerResponseDTO;
import tn.ghassen.inventory.dto.Customer.CustomerUpdateDTO;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.entity.Customer;
import tn.ghassen.inventory.mapper.CustomerMapper;
import tn.ghassen.inventory.repository.CompanyRepository;
import tn.ghassen.inventory.repository.CustomerRepository;
import tn.ghassen.inventory.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO createCustomer(CustomerCreateDTO dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.getCompanyId()));

        Customer customer = customerMapper.toEntity(dto);
        customer.setCompany(company);

        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return customerMapper.toResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO dto) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        if (dto.getCompanyId() != null) {
            Company company = companyRepository.findById(dto.getCompanyId())
                    .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.getCompanyId()));
            existing.setCompany(company);
        }

        customerMapper.updateEntity(existing, dto);

        Customer updatedCustomer = customerRepository.save(existing);
        return customerMapper.toResponseDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }
}