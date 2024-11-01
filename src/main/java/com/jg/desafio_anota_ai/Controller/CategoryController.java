package com.jg.desafio_anota_ai.Controller;

import com.jg.desafio_anota_ai.Mapper.CategoryMapper;
import com.jg.desafio_anota_ai.Services.CategoryService;
import com.jg.desafio_anota_ai.domain.category.Category;
import com.jg.desafio_anota_ai.domain.category.CategoryDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return ResponseEntity.accepted().body(categoryMapper.categoryDTOS(categoryService.getAllCategories()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getOneCategory(@PathVariable("id") String id){
        return ResponseEntity.accepted().body(categoryMapper.toDTO(categoryService.getOneCategory(id)));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.accepted().body(categoryMapper.toDTO(categoryService.insertCategory(categoryDTO)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable ("id") String id, @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.accepted().body(categoryMapper.toDTO(categoryService.updateCategory(id,categoryDTO)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        categoryService.deleteCategory(id);
        return ResponseEntity.accepted().body("ID deletado com sucesso");
    }
}
