package com.qlik.demo.java.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Booking(
        String id,
        UUID userId,
        String destination,
        OffsetDateTime bookingDate
) {
}
