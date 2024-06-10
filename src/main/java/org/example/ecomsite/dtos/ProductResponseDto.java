package org.example.ecomsite.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDto {
    private String productName;
    private String description;
    private double price;
    private UUID id;
    private String categoryName;
}
