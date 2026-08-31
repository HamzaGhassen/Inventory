package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.Purchase.PurchaseCreateDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseResponseDTO;
import tn.ghassen.inventory.dto.Purchase.PurchaseUpdateDTO;
import tn.ghassen.inventory.entity.*;
import tn.ghassen.inventory.mapper.PurchaseItemMapper;
import tn.ghassen.inventory.mapper.PurchaseMapper;
import tn.ghassen.inventory.repository.*;
import tn.ghassen.inventory.service.PurchaseService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final PurchaseMapper purchaseMapper;
    private final PurchaseItemMapper purchaseItemMapper;

    @Override
    public PurchaseResponseDTO createPurchase(PurchaseCreateDTO dto) {
        Supplier supplier = supplierRepository.findById(dto.supplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + dto.supplierId()));

        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.userId()));

        Company company = companyRepository.findById(dto.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.companyId()));

        Purchase purchase = purchaseMapper.toEntity(dto);
        purchase.setSupplier(supplier);
        purchase.setUser(user);
        purchase.setCompany(company);

        if (dto.purchaseItems() != null && !dto.purchaseItems().isEmpty()) {
            List<PurchaseItem> items = new ArrayList<>();
            for (var itemDto : dto.purchaseItems()) {
                PurchaseItem item = purchaseItemMapper.toEntity(itemDto);
                item.setPurchase(purchase);

                if (itemDto.productId() != null) {
                    Product product = productRepository.findById(itemDto.productId())
                            .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemDto.productId()));
                    item.setProduct(product);
                }

                if (itemDto.rawMaterialId() != null) {
                    RawMaterial rawMaterial = rawMaterialRepository.findById(itemDto.rawMaterialId())
                            .orElseThrow(() -> new RuntimeException("RawMaterial not found with id: " + itemDto.rawMaterialId()));
                    item.setRawMaterial(rawMaterial);
                }

                items.add(item);
            }
            purchase.setPurchaseItems(items);
        }

        Purchase savedPurchase = purchaseRepository.save(purchase);
        return purchaseMapper.toResponseDTO(savedPurchase);
    }

    @Override
    public PurchaseResponseDTO getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));
        return purchaseMapper.toResponseDTO(purchase);
    }

    @Override
    public List<PurchaseResponseDTO> getAllPurchases() {
        return purchaseRepository.findAll()
                .stream()
                .map(purchaseMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PurchaseResponseDTO updatePurchase(Long id, PurchaseUpdateDTO dto) {
        Purchase existing = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));

        purchaseMapper.updateEntity(existing, dto);

        Purchase updatedPurchase = purchaseRepository.save(existing);
        return purchaseMapper.toResponseDTO(updatedPurchase);
    }

    @Override
    public void deletePurchase(Long id) {
        if (!purchaseRepository.existsById(id)) {
            throw new RuntimeException("Purchase not found with id: " + id);
        }
        purchaseRepository.deleteById(id);
    }
}