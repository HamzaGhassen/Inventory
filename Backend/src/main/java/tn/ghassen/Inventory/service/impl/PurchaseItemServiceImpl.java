package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemCreateDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemResponseDTO;
import tn.ghassen.inventory.dto.PurchaseItem.PurchaseItemUpdateDTO;
import tn.ghassen.inventory.entity.Product;
import tn.ghassen.inventory.entity.Purchase;
import tn.ghassen.inventory.entity.PurchaseItem;
import tn.ghassen.inventory.entity.RawMaterial;
import tn.ghassen.inventory.mapper.PurchaseItemMapper;
import tn.ghassen.inventory.repository.ProductRepository;
import tn.ghassen.inventory.repository.PurchaseItemRepository;
import tn.ghassen.inventory.repository.PurchaseRepository;
import tn.ghassen.inventory.repository.RawMaterialRepository;
import tn.ghassen.inventory.service.PurchaseItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseItemServiceImpl implements PurchaseItemService {

    private final PurchaseItemRepository purchaseItemRepository;
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final PurchaseItemMapper purchaseItemMapper;

    @Override
    public PurchaseItemResponseDTO createPurchaseItem(PurchaseItemCreateDTO dto) {
        PurchaseItem item = purchaseItemMapper.toEntity(dto);

        if (dto.purchaseId() != null) {
            Purchase purchase = purchaseRepository.findById(dto.purchaseId())
                    .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + dto.purchaseId()));
            item.setPurchase(purchase);
        }

        if (dto.productId() != null) {
            Product product = productRepository.findById(dto.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + dto.productId()));
            item.setProduct(product);
        }

        if (dto.rawMaterialId() != null) {
            RawMaterial rawMaterial = rawMaterialRepository.findById(dto.rawMaterialId())
                    .orElseThrow(() -> new RuntimeException("RawMaterial not found with id: " + dto.rawMaterialId()));
            item.setRawMaterial(rawMaterial);
        }

        PurchaseItem savedItem = purchaseItemRepository.save(item);
        return purchaseItemMapper.toResponseDTO(savedItem);
    }

    @Override
    public PurchaseItemResponseDTO getPurchaseItemById(Long id) {
        PurchaseItem item = purchaseItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseItem not found with id: " + id));
        return purchaseItemMapper.toResponseDTO(item);
    }

    @Override
    public List<PurchaseItemResponseDTO> getAllPurchaseItems() {
        return purchaseItemRepository.findAll()
                .stream()
                .map(purchaseItemMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PurchaseItemResponseDTO updatePurchaseItem(Long id, PurchaseItemUpdateDTO dto) {
        PurchaseItem existing = purchaseItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseItem not found with id: " + id));

        if (dto.purchaseId() != null) {
            Purchase purchase = purchaseRepository.findById(dto.purchaseId())
                    .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + dto.purchaseId()));
            existing.setPurchase(purchase);
        }

        if (dto.productId() != null) {
            Product product = productRepository.findById(dto.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + dto.productId()));
            existing.setProduct(product);
        }

        if (dto.rawMaterialId() != null) {
            RawMaterial rawMaterial = rawMaterialRepository.findById(dto.rawMaterialId())
                    .orElseThrow(() -> new RuntimeException("RawMaterial not found with id: " + dto.rawMaterialId()));
            existing.setRawMaterial(rawMaterial);
        }

        purchaseItemMapper.updateEntity(existing, dto);

        PurchaseItem updatedItem = purchaseItemRepository.save(existing);
        return purchaseItemMapper.toResponseDTO(updatedItem);
    }

    @Override
    public void deletePurchaseItem(Long id) {
        if (!purchaseItemRepository.existsById(id)) {
            throw new RuntimeException("PurchaseItem not found with id: " + id);
        }
        purchaseItemRepository.deleteById(id);
    }
}
