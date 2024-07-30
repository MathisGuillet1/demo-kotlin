package com.qlik.demo.kotlin.model

import java.time.OffsetDateTime
import java.util.*

data class Booking(
    val id: String,
    val userId: UUID,
    val destination: String,
    val bookingDate: OffsetDateTime
)
