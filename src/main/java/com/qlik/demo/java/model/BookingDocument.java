package com.qlik.demo.java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;

@Document(collection = "bookings")
public record BookingDocument(
        @Id String id,
        UUID userId,
        String destination,
        OffsetDateTime bookingDate
) {
}
