package com.qlik.demo.kotlin.util

import com.qlik.demo.kotlin.model.Booking
import com.qlik.demo.kotlin.model.Train
import com.qlik.demo.kotlin.model.TrainDocument

object ModelMapper {
    fun convertToTrain(document: TrainDocument) =
        Train(
            id = document.id,
            destination = document.destination,
            seatOption = document.seatOption
        )

    fun convertToBooking(document: com.qlik.demo.kotlin.model.BookingDocument) =
        Booking(
            id = document.id,
            destination = document.destination,
            userId = document.userId,
            bookingDate = document.bookingDate
        )
}