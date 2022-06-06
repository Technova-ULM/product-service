package com.technova.productservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Productdto {
    @NotBlank(message = "product name cannot be null")
    private String productName;
    @NotBlank(message = "product desc cannot be null")
    private String productDesc;
    @NotBlank(message = "quantity cannot be null")
    private Integer quantity;
    @NotBlank(message = "pricePerUnit cannot be null")
    private Double pricePerUnit;

    @NotBlank(message = "addedby cannot be null")
    private String addedBy;

    @NotBlank(message = "category cannot be null")
    private String category;

}
