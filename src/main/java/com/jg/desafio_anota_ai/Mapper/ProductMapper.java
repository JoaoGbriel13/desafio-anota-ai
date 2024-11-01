package com.jg.desafio_anota_ai.Mapper;

import com.jg.desafio_anota_ai.domain.product.Product;
import com.jg.desafio_anota_ai.domain.product.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @Autowired
    public ModelMapper mapper;

    public ProductDTO toDTO(Product product){
        return mapper.map(product, ProductDTO.class);
    }
    public Product toEntity(ProductDTO productDTO){
        return mapper.map(productDTO, Product.class);
    }

    public List<ProductDTO> productDTOS(List<Product> products){
        return products.stream().map(element -> mapper.map(element, ProductDTO.class)).collect(Collectors.toList());
    }
}
