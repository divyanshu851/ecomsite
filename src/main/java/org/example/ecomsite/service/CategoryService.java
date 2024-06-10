package org.example.ecomsite.service;

import org.example.ecomsite.dtos.CategoryRequestDto;
import org.example.ecomsite.dtos.CategoryResponseDto;
import org.example.ecomsite.dtos.CategoryWithProductResponseDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CategoryResponseDto addCategory(CategoryRequestDto requestDto);
    List<CategoryResponseDto> getAllCategory();

    boolean removeCategory(UUID id);
    CategoryResponseDto getCategoryByName(String name);

    CategoryWithProductResponseDto getCategoryWithProducts(UUID id);

}
