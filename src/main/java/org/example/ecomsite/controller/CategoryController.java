package org.example.ecomsite.controller;


import org.example.ecomsite.dtos.CategoryRequestDto;
import org.example.ecomsite.dtos.CategoryResponseDto;
import org.example.ecomsite.dtos.CategoryWithProductResponseDto;
import org.example.ecomsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

@RestController
public class CategoryController {
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto requestDto){
    return ResponseEntity.ok(categoryService.addCategory(requestDto));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id")UUID id){
        return ResponseEntity.ok(categoryService.removeCategory(id));
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<CategoryResponseDto> categoryByName(@PathVariable("name") String name){
        CategoryResponseDto responseDto = categoryService.getCategoryByName(name);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/product/category/{id}")
    public ResponseEntity<CategoryWithProductResponseDto> categoryWithProducts(@PathVariable("id") UUID id){
        CategoryWithProductResponseDto categoryWithProductResponseDto = categoryService.getCategoryWithProducts(id);
        return ResponseEntity.ok(categoryWithProductResponseDto);
    }
}
