package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemCreateDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemResponseDTO;
import tn.ghassen.inventory.dto.Sale_Item.SaleItemUpdateDTO;
import tn.ghassen.inventory.entity.*;
import tn.ghassen.inventory.mapper.SaleItemMapper;
import tn.ghassen.inventory.repository.ProductRepository;
import tn.ghassen.inventory.repository.SaleItemRepository;
import tn.ghassen.inventory.repository.SaleRepository;
import tn.ghassen.inventory.repository.UserRepository;
import tn.ghassen.inventory.service.SaleItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleItemServiceImpl implements SaleItemService {

    private final SaleItemRepository saleItemRepository;
    private final SaleItemMapper saleItemMapper;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final UserRepository userRepository;

    @Override
    public SaleItemResponseDTO createSaleItem(SaleItemCreateDTO dto) {

        // 1. Get currently authenticated user
        User currentUser = getAuthenticatedUser();

        // 2. Get company from authenticated user
        Company company = currentUser.getCompany();

        if (company == null) {
            throw new RuntimeException(
                    "Company not found for authenticated user: " + currentUser.getEmail()
            );
        }

        // 3. Check Product exists
        Product product = productRepository
                .findByIdAndCompanyId(dto.productId(), company.getId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + dto.productId()));

        // 4. Check Sale exists and belongs to this company
        Sale sale = saleRepository.findByIdAndCompanyId(dto.saleId(), company.getId())
                .orElseThrow(() ->
                        new RuntimeException("Sale not found with id: " + dto.saleId())
                );

        // 5. Map DTO to entity
        SaleItem item = saleItemMapper.toEntity(dto);

        // 6. Assign the existing entities
        item.setProduct(product);
        item.setSale(sale);

        // 7. Save
        SaleItem savedItem = saleItemRepository.save(item);

        // 8. Return response DTO
        return saleItemMapper.toResponseDTO(savedItem);
    }
    @Override
    public SaleItemResponseDTO getSaleItemById(Long id) {

        User currentUser = getAuthenticatedUser();

        Company company = currentUser.getCompany();

        if (company == null) {
            throw new RuntimeException("User is not associated with a company");
        }

        SaleItem item = saleItemRepository
                .findByIdAndSaleCompanyId(id, company.getId())
                .orElseThrow(() ->
                        new RuntimeException("Sale item not found"));

        return saleItemMapper.toResponseDTO(item);
    }

    @Override
    public List<SaleItemResponseDTO> getAllSaleItem() {

        User currentUser = getAuthenticatedUser();

        Company company = currentUser.getCompany();

        if (company == null) {
            throw new RuntimeException("User is not associated with a company");
        }

        return saleItemRepository.findBySaleCompanyId(company.getId())
                .stream()
                .map(saleItemMapper::toResponseDTO)
                .toList();
    }


    @Override
    public SaleItemResponseDTO updateSaleItem(Long id, SaleItemUpdateDTO dto) {
        User currentUser = getAuthenticatedUser();

        Company company = currentUser.getCompany();

        if (company == null) {
            throw new RuntimeException("User is not associated with a company");
        }

        SaleItem existing = saleItemRepository
                .findByIdAndSaleCompanyId(id, company.getId())
                .orElseThrow(() ->
                        new RuntimeException("Sale item not found"));

        Product product = productRepository
                .findByIdAndCompanyId(dto.productId(), company.getId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + dto.productId()));

        Sale sale = saleRepository.findByIdAndCompanyId(dto.saleId(), company.getId())
                .orElseThrow(() ->
                        new RuntimeException("Sale not found with id: " + dto.saleId()));
    saleItemMapper.updateEntity(existing,dto);

        existing.setProduct(product);
        existing.setSale(sale);

    SaleItem savedItem = saleItemRepository.save(existing);

        return saleItemMapper.toResponseDTO(savedItem);
    }

    @Override
    public void deleteSaleItem(Long id) {
        User currentUser = getAuthenticatedUser();

        Company company = currentUser.getCompany();

        if (company == null) {
            throw new RuntimeException("User is not associated with a company");
        }

        if (!saleItemRepository.existsByIdAndSaleCompanyId(id, company.getId())) {
            throw new RuntimeException("Sale item not found");
        }

        saleItemRepository.deleteById(id);
    }

    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            throw new RuntimeException("Authenticated user not found in Security Context");
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof User user) {
            return user;
        }

        String email;
        if (principal instanceof UserDetails userDetails) {
            email = userDetails.getUsername();
        } else if (principal instanceof String str) {
            email = str;
        } else {
            email = authentication.getName();
        }

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Authenticated user not found with email: " + email));
    }
}
