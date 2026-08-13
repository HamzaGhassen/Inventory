package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Customer.CustomerCreateDTO;
import tn.ghassen.inventory.dto.Customer.CustomerResponseDTO;
import tn.ghassen.inventory.dto.Customer.CustomerUpdateDTO;
import tn.ghassen.inventory.entity.Customer;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerCreateDTO dto) {
        Customer customer = new Customer();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setTaxNumber(dto.getTaxNumber());
        customer.setLogo(dto.getLogo());

        return customer;
    }

    public CustomerResponseDTO toResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());
        dto.setTaxNumber(customer.getTaxNumber());
        dto.setLogo(customer.getLogo());


        dto.setCompanyId(customer.getCompany().getId());


        return dto;
    }

    public void updateEntity(Customer customer, CustomerUpdateDTO dto) {
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setTaxNumber(dto.getTaxNumber());
        customer.setLogo(dto.getLogo());
    }
}