package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.Customer.CustomerCreateDTO;
import tn.ghassen.inventory.dto.Customer.CustomerResponseDTO;
import tn.ghassen.inventory.dto.Customer.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerCreateDTO dto);

    CustomerResponseDTO getCustomerById(Long id);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO dto);

    void deleteCustomer(Long id);
}