package com.technova.productservice.service;

import com.technova.productservice.dto.Productdto;
import com.technova.productservice.model.Product;
import com.technova.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public  Product createProduct(Productdto productdto) {
        Product product= Product.builder().productDesc(productdto.getProductDesc()).productName(productdto.getProductName()).addedBy(productdto.getAddedBy())
                .category(productdto.getCategory()).pricePerUnit(productdto.getPricePerUnit()).quantity(productdto.getQuantity()).build();
       return  productRepo.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }
}
