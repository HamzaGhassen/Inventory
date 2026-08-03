package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.Sale;

import java.util.List;

public interface SaleService {
    Sale createSale(Sale sale);

    Sale getSaleById(Long id);

     List<Sale> getAllSales();

     Sale updateSale(Long id , Sale sale);

     void deleteSale(Long id);
}
