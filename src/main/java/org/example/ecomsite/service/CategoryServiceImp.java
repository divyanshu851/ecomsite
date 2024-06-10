package org.example.ecomsite.service;


import org.example.ecomsite.dtos.CategoryRequestDto;
import org.example.ecomsite.dtos.CategoryResponseDto;
import org.example.ecomsite.dtos.CategoryWithProductResponseDto;
import org.example.ecomsite.entities.Category;
import org.example.ecomsite.exception.CategoryAlreadyFoundException;
import org.example.ecomsite.exception.CategoryNotFoundException;
import org.example.ecomsite.mapper.CategoryMapper;
import org.example.ecomsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDto addCategory(CategoryRequestDto requestDto) throws CategoryAlreadyFoundException {
        Category category = CategoryMapper.categoryRequestDtoToCategory(requestDto);
        Optional<Category> savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory.isPresent()){
            throw new CategoryAlreadyFoundException(savedCategory.get().getCategoryName() + " Category is already found in the repository");
        }
        category = categoryRepository.save(category);
        return CategoryMapper.categoryToCategoryResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for(Category category : categories){
            categoryResponseDtos.add(CategoryMapper.categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }

    @Override
    public boolean removeCategory(UUID id) {
        categoryRepository.deleteById(id);
        return true;
    }

    public CategoryResponseDto getCategoryByName(String categoryName){
        Category category = categoryRepository.findByCategoryName(categoryName).get();
        return CategoryMapper.categoryToCategoryResponseDto(category);
    }

    @Override
    public CategoryWithProductResponseDto getCategoryWithProducts(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category not found with this id"));
        return CategoryMapper.CategoryToCategoryResponseWithProductMapper(category);
    }

}
