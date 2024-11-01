package com.jg.desafio_anota_ai.domain.category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private String title;
    private String ownerId;
    private String description;
}
