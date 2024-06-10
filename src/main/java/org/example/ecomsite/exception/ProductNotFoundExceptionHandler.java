package org.example.ecomsite.exception;


import org.example.ecomsite.dtos.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity productNotfoundHandler(ProductNotFoundException pe){
        ExceptionResponseDto responseDto = new ExceptionResponseDto(pe.getMessage(), 404);
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
}
