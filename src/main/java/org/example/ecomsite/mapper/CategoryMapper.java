package org.example.ecomsite.mapper;

import org.example.ecomsite.dtos.*;
import org.example.ecomsite.entities.Category;
import org.example.ecomsite.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static Category categoryRequestDtoToCategory(CategoryRequestDto dto){
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto(Category category){
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setCategoryName(category.getCategoryName());
        responseDto.setId(category.getId());
        return responseDto;
    }

    public static CategoryWithProductResponseDto CategoryToCategoryResponseWithProductMapper(Category category){
        CategoryWithProductResponseDto categoryWithProductResponseDto = new CategoryWithProductResponseDto();
        categoryWithProductResponseDto.setCategoryName(category.getCategoryName());
        List<ProductResponseDtoForOneCategory> productResponseDtos = new ArrayList<>();
        for(Product product : category.getProducts()){
            ProductResponseDtoForOneCategory responseDto = ProductMapper.productToProductResponseDtoForOneCategory(product);
            productResponseDtos.add(responseDto);
        }
        List<ProductResponseDtoForOneCategory> categoryProducts = new ArrayList<>(productResponseDtos);
        categoryWithProductResponseDto.setProducts(categoryProducts);
        return categoryWithProductResponseDto;
    }
}
