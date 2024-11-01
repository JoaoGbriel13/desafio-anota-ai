package com.jg.desafio_anota_ai.Handler;

import com.jg.desafio_anota_ai.domain.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProductNotFoundException extends RuntimeException {
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("Product not found");
        pb.setDetail("No product was found with that ID");
        return pb;
    }
}
