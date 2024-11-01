package com.jg.desafio_anota_ai.Mapper;

import com.jg.desafio_anota_ai.domain.category.Category;
import com.jg.desafio_anota_ai.domain.category.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CategoryMapper {
    @Autowired
    public ModelMapper mapper;

    public CategoryDTO toDTO(Category category){
        return mapper.map(category, CategoryDTO.class);
    }
    public Category toEntity(CategoryDTO categoryDTO){
        return mapper.map(categoryDTO, Category.class);
    }
    public List<CategoryDTO> categoryDTOS(List<Category> category){
        return category.stream().map(element -> mapper.map(element, CategoryDTO.class)).collect(Collectors.toList());
    }
}
