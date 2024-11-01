package com.jg.desafio_anota_ai.domain.product;

import com.jg.desafio_anota_ai.domain.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String title;
    private String ownerId;
    private String categoryId;
    private BigDecimal price;
    private String description;
}
