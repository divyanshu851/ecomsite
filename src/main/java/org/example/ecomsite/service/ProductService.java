package org.example.ecomsite.service;

import org.example.ecomsite.dtos.ProductResponseDto;
import org.example.ecomsite.entities.Product;
import org.example.ecomsite.dtos.ProductRequestDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProduct(UUID id);
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);
    ProductResponseDto getProductById(UUID id);

    ProductResponseDto updateProductService(UUID id, ProductRequestDto requestDto);
}
