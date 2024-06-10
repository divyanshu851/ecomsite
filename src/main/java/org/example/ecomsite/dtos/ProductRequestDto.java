package org.example.ecomsite.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String productName;
    private String description;
    private double price;
    private String categoryName;
}
