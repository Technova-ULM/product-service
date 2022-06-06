package com.technova.productservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus, String message, Object data, Object errors){
        Map<String,Object> response= new HashMap<>();
        response.put("statusCode", httpStatus);
        response.put("message",message);
        response.put("data",data);
        response.put("errors",errors);
        return new ResponseEntity<>(response,httpStatus);

    }
}
