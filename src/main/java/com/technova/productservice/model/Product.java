package com.technova.productservice.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_db")
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDesc;
    private Integer quantity;
    private Double pricePerUnit;
    private String addedBy;
    private String category;
}
