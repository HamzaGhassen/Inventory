package tn.ghassen.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.PurchaseItem;
import tn.ghassen.inventory.repository.PurchaseItemRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PurchaseItemServiceImpl implements PurchaseItemService{

    private final PurchaseItemRepository purchaseItemRepository;
    @Override
    public PurchaseItem createPurchaseItem(PurchaseItem purchaseItem) {
        return purchaseItemRepository.save(purchaseItem);

    }

    @Override
    public PurchaseItem getPurchaseItemById(Long id) {
        return purchaseItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("purchaseItem not found"));
    }

    @Override
    public List<PurchaseItem> getAllPurchaseItem() {
        return purchaseItemRepository.findAll();
    }

    @Override
    public PurchaseItem updatePurchaseItem(Long id, PurchaseItem purchaseItem) {
        PurchaseItem existing = getPurchaseItemById(id);

        existing.setQuantity(purchaseItem.getQuantity());
        existing.setUnitPrice(purchaseItem.getUnitPrice());
        existing.setDiscount(purchaseItem.getDiscount());
        existing.setTax(purchaseItem.getTax());
        existing.setTotalPrice(purchaseItem.getTotalPrice());
        existing.setSubtotal(purchaseItem.getSubtotal());

        return purchaseItemRepository.save(existing);
    }

    @Override
    public void deletePurchaseItem(Long id) {
        purchaseItemRepository.deleteById(id);
    }
}
