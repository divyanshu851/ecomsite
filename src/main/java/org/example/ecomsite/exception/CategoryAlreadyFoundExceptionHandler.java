package org.example.ecomsite.exception;

import org.example.ecomsite.dtos.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class CategoryAlreadyFoundExceptionHandler {

    @ExceptionHandler(CategoryAlreadyFoundException.class)
    public ResponseEntity handleCategoryAlreadyFoundException(CategoryAlreadyFoundException ce){
        ExceptionResponseDto responseDto = new ExceptionResponseDto(ce.getMessage(), 404);
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
}
