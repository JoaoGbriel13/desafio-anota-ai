package com.jg.desafio_anota_ai.Services;

import com.jg.desafio_anota_ai.Handler.CategoryNotFoundException;
import com.jg.desafio_anota_ai.Mapper.CategoryMapper;
import com.jg.desafio_anota_ai.Services.AWS.AWSService;
import com.jg.desafio_anota_ai.Services.AWS.MessageDTO;
import com.jg.desafio_anota_ai.domain.category.Category;
import com.jg.desafio_anota_ai.domain.category.CategoryDTO;
import com.jg.desafio_anota_ai.repositories.CategoryRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private AWSService awsService;

    public Category getOneCategory(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new CategoryNotFoundException();
        }
        return category.get();
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category insertCategory(CategoryDTO categoryDTO){
        Category category = categoryMapper.toEntity(categoryDTO);
        categoryRepository.insert(category);
        awsService.publish(new MessageDTO(category.toString()));
        return category;
    }

    public Category updateCategory(String id, CategoryDTO categoryDTO) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new CategoryNotFoundException();
        }
        category.get().setDescription(categoryDTO.getDescription());
        category.get().setTitle(categoryDTO.getTitle());
        categoryRepository.save(category.get());
        awsService.publish(new MessageDTO(category.get().toString()));
        return category.get();
    }

    public void deleteCategory(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new CategoryNotFoundException();
        }
        categoryRepository.delete(category.get());
    }

}
