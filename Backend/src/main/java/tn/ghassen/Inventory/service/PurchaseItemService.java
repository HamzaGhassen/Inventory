package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.PurchaseItem;

import java.util.List;

public interface PurchaseItemService {

    PurchaseItem createPurchaseItem(PurchaseItem purchaseItem);

    PurchaseItem getPurchaseItemById(Long id);

    List<PurchaseItem> getAllPurchaseItem();

    PurchaseItem updatePurchaseItem(Long id , PurchaseItem purchaseItem);

    void deletePurchaseItem(Long id);
}
