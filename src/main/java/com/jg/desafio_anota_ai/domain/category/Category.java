package com.jg.desafio_anota_ai.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "categories")
public class Category {
    @Id
    private String id;
    private String title;
    private String ownerId;
    private String description;

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", this.title);
        jsonObject.put("description", this.description);
        jsonObject.put("ownerId", this.ownerId);
        jsonObject.put("id", this.id);
        jsonObject.put("type", "category");

        return jsonObject.toString();
    }
}
