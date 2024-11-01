package com.jg.desafio_anota_ai.Controller;

import com.jg.desafio_anota_ai.Mapper.ProductMapper;
import com.jg.desafio_anota_ai.Services.ProductService;
import com.jg.desafio_anota_ai.domain.product.Product;
import com.jg.desafio_anota_ai.domain.product.ProductDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.accepted().body(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("id") String id){
        return ResponseEntity.accepted().body(productService.getOneProduct(id));
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO){
        return ResponseEntity.accepted().body(productService.insert(productDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok().body(productService.update(id,productDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        productService.delete(id);
        return ResponseEntity.ok().body("Your product was deleted");
    }
}
