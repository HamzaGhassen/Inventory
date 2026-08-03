package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Sale;
import tn.ghassen.inventory.repository.SaleRepository;
import tn.ghassen.inventory.service.SaleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService {

    private final SaleRepository saleRepository;


    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        Sale existing = getSaleById(id);

        existing.setDescription(sale.getDescription());
        existing.setCustomer(sale.getCustomer());
        existing.setUser(sale.getUser());
        existing.setCompany(sale.getCompany());
        existing.setTotalAmount(sale.getTotalAmount());
        existing.setPaymentStatus(sale.getPaymentStatus());
        existing.setPaymentMethod(sale.getPaymentMethod());

        return saleRepository.save(existing);

    }

    @Override
    public void deleteSale(Long id) {
    saleRepository.deleteById(id);
    }
}
