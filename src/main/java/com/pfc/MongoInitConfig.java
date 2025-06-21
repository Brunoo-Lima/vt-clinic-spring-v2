package com.pfc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoInitConfig implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        if (!mongoTemplate.collectionExists("consultas")) {
            mongoTemplate.createCollection("consultas");
        }
        if (!mongoTemplate.collectionExists("veterinarios")) {
            mongoTemplate.createCollection("veterinarios");
        }
        if (!mongoTemplate.collectionExists("pets")) {
            mongoTemplate.createCollection("pets");
        }

        if (!mongoTemplate.collectionExists("tutores")) {
            mongoTemplate.createCollection("tutores");
        }
    }
}
