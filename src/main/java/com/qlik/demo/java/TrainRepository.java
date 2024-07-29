package com.qlik.demo.java;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainRepository {

    private final MongoTemplate mongoTemplate;

    public TrainRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<TrainDocument> findAll() {
        return mongoTemplate.findAll(TrainDocument.class);
    }
}
