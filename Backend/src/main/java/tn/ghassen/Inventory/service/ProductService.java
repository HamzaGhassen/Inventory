package tn.ghassen.inventory.service;

import tn.ghassen.inventory.dto.Product.ProductCreateDTO;
import tn.ghassen.inventory.dto.Product.ProductResponseDTO;
import tn.ghassen.inventory.dto.Product.ProductUpdateDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductCreateDTO dto);

    ProductResponseDTO getProductById(Long id);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO updateProduct(Long id, ProductUpdateDTO dto);

    void deleteProduct(Long id);
}