package com.qlik.demo.kotlin

import com.qlik.demo.kotlin.model.TrainDocument
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class TrainRepository(private val mongoTemplate: MongoTemplate) {

    fun findAll(): List<TrainDocument> = mongoTemplate.findAll(TrainDocument::class.java)
}