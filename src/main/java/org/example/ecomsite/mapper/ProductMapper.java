package org.example.ecomsite.mapper;

import org.example.ecomsite.dtos.ProductRequestDto;
import org.example.ecomsite.dtos.ProductResponseDto;
import org.example.ecomsite.dtos.ProductResponseDtoForOneCategory;
import org.example.ecomsite.entities.Product;

public class ProductMapper {
    public static Product productRequestToProduct(ProductRequestDto dto){
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    public static ProductResponseDto productToProductResponseDTO(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setId(product.getId());
        productResponseDto.setCategoryName(product.getCategory().getCategoryName());
        return productResponseDto;
    }

    public static ProductResponseDtoForOneCategory productToProductResponseDtoForOneCategory(Product product){
        ProductResponseDtoForOneCategory responseDtoForOneCategory = new ProductResponseDtoForOneCategory();
        responseDtoForOneCategory.setDescription(product.getDescription());
        responseDtoForOneCategory.setProductName(product.getProductName());
        responseDtoForOneCategory.setPrice(product.getPrice());
        return responseDtoForOneCategory;
    }
}
