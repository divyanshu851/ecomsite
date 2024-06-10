package org.example.ecomsite.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDto {
    private String categoryName;
    private UUID id;
}
