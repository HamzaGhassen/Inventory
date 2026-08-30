package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.dto.Product.ProductCreateDTO;
import tn.ghassen.inventory.dto.Product.ProductResponseDTO;
import tn.ghassen.inventory.dto.Product.ProductUpdateDTO;
import tn.ghassen.inventory.entity.Company;
import tn.ghassen.inventory.entity.Product;
import tn.ghassen.inventory.mapper.ProductMapper;
import tn.ghassen.inventory.repository.CompanyRepository;
import tn.ghassen.inventory.repository.ProductRepository;
import tn.ghassen.inventory.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO createProduct(ProductCreateDTO dto) {
        Company company = companyRepository.findById(dto.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.companyId()));

        Product product = productMapper.toEntity(dto);
        product.setCompany(company);

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return productMapper.toResponse(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductUpdateDTO dto) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        if (dto.companyId() != null) {
            Company company = companyRepository.findById(dto.companyId())
                    .orElseThrow(() -> new RuntimeException("Company not found with id: " + dto.companyId()));
            existing.setCompany(company);
        }

        productMapper.updateEntity(existing, dto);

        Product updatedProduct = productRepository.save(existing);
        return productMapper.toResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}