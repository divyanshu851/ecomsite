package org.example.ecomsite.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.ecomsite.entities.Product;

import java.util.List;

@Getter
@Setter
public class CategoryWithProductResponseDto {
    private String categoryName;
    private List<ProductResponseDtoForOneCategory> products;
}
