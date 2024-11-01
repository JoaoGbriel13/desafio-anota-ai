package com.jg.desafio_anota_ai.Config.Mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {
    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoConfigure());
    }
    @Bean
    public MongoDatabaseFactory mongoConfigure() {
        return new SimpleMongoClientDatabaseFactory("mongodb://root:example@localhost:27017/product-catalog?authSource=admin");
    }
}
