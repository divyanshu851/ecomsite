package org.example.ecomsite.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String productName;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn
    private Category category;
}
