package com.jg.desafio_anota_ai.Services;

import com.jg.desafio_anota_ai.Handler.ProductNotFoundException;
import com.jg.desafio_anota_ai.Mapper.ProductMapper;
import com.jg.desafio_anota_ai.Services.AWS.AWSService;
import com.jg.desafio_anota_ai.Services.AWS.MessageDTO;
import com.jg.desafio_anota_ai.domain.product.Product;
import com.jg.desafio_anota_ai.domain.product.ProductDTO;
import com.jg.desafio_anota_ai.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AWSService awsService;

    public Product getOneProduct(String id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException();
        }
        return product.get();
    }
    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()){
            throw new ProductNotFoundException();
        }
        return products;
    }
    public Product insert(ProductDTO productDTO){
        Product newProduct = new Product(productDTO);
        newProduct.setCategory(categoryService.getOneCategory(productDTO.getCategoryId()));
        productRepository.insert(newProduct);
        awsService.publish(new MessageDTO(newProduct.toString()));
        return newProduct;
    }
    public Product update(String id, ProductDTO productDTO){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException();
        }
        product.get().setCategory(categoryService.getOneCategory(productDTO.getCategoryId()));
        product.get().setTitle(productDTO.getTitle());
        product.get().setDescription(productDTO.getDescription());
        product.get().setPrice(productDTO.getPrice());

        productRepository.save(product.get());
        awsService.publish(new MessageDTO(product.get().toString()));
        return product.get();
    }
    public void delete(String id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException();
        }
        productRepository.delete(product.get());
    }
}
