package org.example.ecomsite.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String userName;
    private String mobileNumber;
    private String gmail;
    private List<Product> productList;
}
