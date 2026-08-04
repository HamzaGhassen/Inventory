package tn.ghassen.inventory.service;

import tn.ghassen.inventory.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}