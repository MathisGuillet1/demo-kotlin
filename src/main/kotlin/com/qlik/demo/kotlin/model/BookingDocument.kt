package com.qlik.demo.kotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.OffsetDateTime
import java.util.*

@Document(collection = "bookings")
data class BookingDocument(
    @Id val id: String,
    val userId: UUID,
    val destination: String,
    val bookingDate: OffsetDateTime
)
