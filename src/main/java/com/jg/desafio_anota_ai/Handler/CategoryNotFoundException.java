package com.jg.desafio_anota_ai.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CategoryNotFoundException extends RuntimeException {
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("Category not found");
        pb.setDetail("No category was found with that ID");
        return pb;
    }
}
