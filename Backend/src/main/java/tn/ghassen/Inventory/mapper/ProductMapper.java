package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.Product.ProductCreateDTO;
import tn.ghassen.inventory.dto.Product.ProductResponseDTO;
import tn.ghassen.inventory.dto.Product.ProductUpdateDTO;
import tn.ghassen.inventory.entity.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductCreateDTO dto){

        Product product = new Product();

        product.setName(dto.name());
        product.setLogo(dto.logo());
        product.setCostPrice(dto.costPrice());
        product.setSellingPrice(dto.sellingPrice());
        product.setUnit(dto.unit());
        product.setQuantity(dto.quantity());
        product.setProductType(dto.productType());

        return product;
    }

    public ProductResponseDTO toResponse(Product product){

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getLogo(),
                product.getCostPrice(),
                product.getSellingPrice(),
                product.getQuantity(),
                product.getProductType(),
                product.getUnit(),
                product.getCompany().getId(),
                product.getCompany().getName()
        );

   }

   public void updateEntity(Product product , ProductUpdateDTO dto){


       product.setName(dto.name());
       product.setLogo(dto.logo());
       product.setCostPrice(dto.costPrice());
       product.setSellingPrice(dto.sellingPrice());
       product.setQuantity(dto.quantity());
       product.setProductType(dto.productType());
       product.setUnit(dto.unit());
   }

}
