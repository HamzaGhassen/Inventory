package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.Purchase.PurchaseCreateDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseResponseDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseUpdateDTO;

import java.util.List;

public interface PurchaseService {

    PurchaseResponseDTO createPurchase(PurchaseCreateDTO dto);

    PurchaseResponseDTO getPurchaseById(Long id);

    List<PurchaseResponseDTO> getAllPurchases();

    PurchaseResponseDTO updatePurchase(Long id, PurchaseUpdateDTO dto);

    void deletePurchase(Long id);
}