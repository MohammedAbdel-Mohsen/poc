package com.poc.retaildiscounts.domain.model.entities;

import com.poc.retaildiscounts.domain.model.enums.ProductCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private ProductCategory productCategory;
    private Double price;
}
