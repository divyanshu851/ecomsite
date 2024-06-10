package org.example.ecomsite.controller;


import org.example.ecomsite.dtos.ProductRequestDto;
import org.example.ecomsite.dtos.ProductResponseDto;
import org.example.ecomsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class productController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> responseDtos = productService.getAllProducts();
        return ResponseEntity.ok(responseDtos);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productDto){
        ProductResponseDto dto = productService.addProduct(productDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") UUID id){
        ProductResponseDto responseDto = productService.getProductById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDto requestDto){
        return ResponseEntity.ok(productService.updateProductService(id, requestDto));
    }
}
