package com.qlik.demo.kotlin.solution.idiomatic.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "trains")
data class TrainDocument(
    @Id val id: String,
    val destination: String,
    val seatOption: SeatOption
)
