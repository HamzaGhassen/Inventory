package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Purchase;
import tn.ghassen.inventory.repository.PurchaseRepository;
import tn.ghassen.inventory.service.PurchaseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase updatePurchase(Long id, Purchase purchase) {

        Purchase existing = getPurchaseById(id);

        existing.setSupplier(purchase.getSupplier());
        existing.setUser(purchase.getUser());
        existing.setCompany(purchase.getCompany());
        existing.setDescription(purchase.getDescription());
        existing.setTotalAmount(purchase.getTotalAmount());
        existing.setPaymentStatus(purchase.getPaymentStatus());
        existing.setPaymentMethod(purchase.getPaymentMethod());

        return purchaseRepository.save(existing);
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }
}