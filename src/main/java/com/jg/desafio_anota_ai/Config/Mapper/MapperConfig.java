package com.jg.desafio_anota_ai.Config.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper mapper(){ return new ModelMapper(); }
}
