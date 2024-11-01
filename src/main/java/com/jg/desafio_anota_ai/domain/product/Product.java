package com.jg.desafio_anota_ai.domain.product;

import com.jg.desafio_anota_ai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String ownerId;
    private Category category;
    private BigDecimal price;
    private String description;

    public Product(ProductDTO productDTO) {
        this.title = productDTO.getTitle();
        this.ownerId = productDTO.getOwnerId();
        this.price = productDTO.getPrice();
        this.description = productDTO.getDescription();
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", this.title);
        jsonObject.put("description", this.description);
        jsonObject.put("ownerId", this.ownerId);
        jsonObject.put("id", this.id);
        jsonObject.put("categoryId", this.category.getId());
        jsonObject.put("price", this.price);
        jsonObject.put("type", "product");

        return jsonObject.toString();
    }
}
