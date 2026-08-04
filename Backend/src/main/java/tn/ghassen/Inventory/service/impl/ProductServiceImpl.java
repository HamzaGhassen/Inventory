package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.Product;
import tn.ghassen.inventory.repository.ProductRepository;
import tn.ghassen.inventory.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product existing = getProductById(id);

        existing.setName(product.getName());
        existing.setLogo(product.getLogo());
        existing.setCostPrice(product.getCostPrice());
        existing.setSellingPrice(product.getSellingPrice());
        existing.setQuantity(product.getQuantity());
        existing.setProductType(product.getProductType());
        existing.setUnit(product.getUnit());
        existing.setCompany(product.getCompany());

        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}