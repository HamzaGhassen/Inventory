package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import tn.ghassen.inventory.entity.SaleItem;
import tn.ghassen.inventory.repository.SaleItemRepository;
import tn.ghassen.inventory.service.SaleItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleItemServiceImpl implements SaleItemService {

    private final SaleItemRepository saleItemRepository;
    @Override
    public SaleItem createSaleItem(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    @Override
    public SaleItem getSaleItemById(Long id) {
        return   saleItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("saleItem not found"));
    }

    @Override
    public List<SaleItem> getAllSaleItem() {
        return saleItemRepository.findAll();
    }

    @Override
    public SaleItem updateSaleItem(Long id, SaleItem saleItem) {
        SaleItem existing = getSaleItemById(id);


        existing.setQuantity(saleItem.getQuantity());
        existing.setUnitPrice(saleItem.getUnitPrice());
        existing.setDiscount(saleItem.getDiscount());
        existing.setTax(saleItem.getTax());
        existing.setTotalPrice(saleItem.getTotalPrice());
        existing.setSubtotal(saleItem.getSubtotal());

        return saleItemRepository.save(existing);
    }

    @Override
    public void deleteSaleItem(Long id) {

    }
}
