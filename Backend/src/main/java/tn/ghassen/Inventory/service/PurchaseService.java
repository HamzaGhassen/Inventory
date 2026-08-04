package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase createPurchase(Purchase purchase);

    Purchase getPurchaseById(Long id);

    List<Purchase> getAllPurchases();

    Purchase updatePurchase(Long id, Purchase purchase);

    void deletePurchase(Long id);
}