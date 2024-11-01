package com.jg.desafio_anota_ai.Handler;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerErrorHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ProblemDetail CategoryNotFound(CategoryNotFoundException categoryNotFoundException){
        return categoryNotFoundException.toProblemDetail();
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ProblemDetail ProductNotFound(ProductNotFoundException productNotFoundException){
        return productNotFoundException.toProblemDetail();
    }
}
