package com.qlik.demo.java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trains")
public record TrainDocument(
        @Id String id,
        String destination,
        SeatOption seatOption
) {
}
