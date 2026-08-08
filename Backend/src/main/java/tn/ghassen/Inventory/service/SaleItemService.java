package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.SaleItem;

import java.util.List;

public interface SaleItemService {

    SaleItem createSaleItem(SaleItem saleItem);

    SaleItem getSaleItemById(Long id);

    List<SaleItem> getAllSaleItem();

    SaleItem updateSaleItem(Long id , SaleItem saleItem);

    void deleteSaleItem(Long id);
}
