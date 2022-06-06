package com.technova.productservice.globalexceptionhandler;


import com.technova.productservice.ProductNotFound;
import com.technova.productservice.dto.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        List<FieldError> errors=ex.getFieldErrors();
        List<String> newErrors=new ArrayList<>();
        if(errors.size()>0){
            for(FieldError error: errors){
                newErrors.add(error.getDefaultMessage());
            }
        }
        return ApiResponse.generateResponse(HttpStatus.BAD_REQUEST,"Data no valid",null,newErrors);
    }

    @ExceptionHandler({ProductNotFound.class})
    public ResponseEntity<Object> handleProductNotFound(Exception ex){
        return ApiResponse.generateResponse(HttpStatus.BAD_REQUEST,ex.getMessage(),null,"Request failed");
    }
}
