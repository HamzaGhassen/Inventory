package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemCreateDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemResponseDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemUpdateDTO;

import java.util.List;

public interface PurchaseItemService {

    PurchaseItemResponseDTO createPurchaseItem(PurchaseItemCreateDTO dto);

    PurchaseItemResponseDTO getPurchaseItemById(Long id);

    List<PurchaseItemResponseDTO> getAllPurchaseItems();

    PurchaseItemResponseDTO updatePurchaseItem(Long id, PurchaseItemUpdateDTO dto);

    void deletePurchaseItem(Long id);
}
