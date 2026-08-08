package tn.ghassen.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.ghassen.inventory.entity.Customer;
import tn.ghassen.inventory.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer CustomerCreate(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id ,
            @RequestBody Customer customer) {
        return customerService.updateCustomer(id,customer);
    }

    @GetMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);    }
}
