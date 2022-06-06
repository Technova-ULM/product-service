package com.technova.productservice.controller;

import com.technova.productservice.ProductNotFound;
import com.technova.productservice.dto.ApiResponse;
import com.technova.productservice.dto.Productdto;
import com.technova.productservice.model.Product;
import com.technova.productservice.service.ProductService;
import com.technova.productservice.util.AppConstants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ProductController {

    private Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    /**
     * It takes a productdto object as a request body, creates a product object using the productdto object and returns a
     * response entity object
     *
     * @param productdto This is the object that will be sent in the request body.
     * @return ResponseEntity<Object>
     */
    @PostMapping(AppConstants.PRODUCTURL)
    public ResponseEntity<Object> createProduct(@RequestBody Productdto productdto){
       Product product= productService.createProduct(productdto);
       if(product!=null){
           return ApiResponse.generateResponse(HttpStatus.OK,"Product created successfully",product,null);
       }
       return ApiResponse.generateResponse(HttpStatus.BAD_REQUEST,"Something!!! went wrong",null,"Request Failed");
    }

    /**
     * It returns the product with the given id.
     *
     * @param id The id of the product to be fetched.
     * @return ResponseEntity<Object>
     */
    @GetMapping(AppConstants.PRODUCTURL+"/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id) throws ProductNotFound {
    Optional<Product> existingProduct=productService.getProductById(id);
    if(existingProduct.isPresent()){
        return ApiResponse.generateResponse(HttpStatus.BAD_REQUEST,"",existingProduct.get(),"Request Failed");
    }
      throw  new ProductNotFound("product with id "+id+"not found");
    }


}
