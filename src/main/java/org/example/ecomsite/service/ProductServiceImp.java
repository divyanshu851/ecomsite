package org.example.ecomsite.service;

import org.example.ecomsite.dtos.ProductRequestDto;
import org.example.ecomsite.dtos.ProductResponseDto;
import org.example.ecomsite.entities.Category;
import org.example.ecomsite.entities.Product;
import org.example.ecomsite.exception.ProductNotFoundException;
import org.example.ecomsite.mapper.ProductMapper;
import org.example.ecomsite.repository.CategoryRepository;
import org.example.ecomsite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> responseDtos = new ArrayList<>();
        for(Product product : products){
            responseDtos.add(ProductMapper.productToProductResponseDTO(product));
        }

        return responseDtos;
    }

    @Override
    public ProductResponseDto getProduct(UUID id) {
        Product product =  productRepository.findById(id).get();
        return ProductMapper.productToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        Product product = ProductMapper.productRequestToProduct(productRequestDto);
        Category category = categoryRepository.findByCategoryName(productRequestDto.getCategoryName()).get();
        product.setCategory(category);
        category.getProducts().add(product);
        categoryRepository.save(category);
        product = productRepository.save(product);
        return ProductMapper.productToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDto getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product with this id is not found in the repository"));
        return ProductMapper.productToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDto updateProductService(UUID id, ProductRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("The product with this id is not found"));
        Category category = categoryRepository.findByCategoryName(requestDto.getCategoryName()).get();
        product.setCategory(category);
        product.setProductName(requestDto.getProductName());
        product.setPrice(requestDto.getPrice());
        product.setDescription(requestDto.getDescription());
        Product savedProduct = productRepository.save(product);
        return ProductMapper.productToProductResponseDTO(savedProduct);
    }

}
