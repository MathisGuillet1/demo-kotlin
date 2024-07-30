package com.qlik.demo.kotlin

import com.qlik.demo.kotlin.model.SeatOption
import com.qlik.demo.kotlin.model.Train
import com.qlik.demo.kotlin.util.ModelMapper
import org.springframework.stereotype.Service
import java.util.*

@Service
class TrainService(
    private val trainRepository: TrainRepository,
    private val bookingRepository: BookingRepository
) {

    fun getTrainByDestination(destination: String, seatOption: SeatOption?): List<Train> {
        // Filtering in memory for the sake of the demo :scream:
        return trainRepository.findAll()
            .filter { destination == it.destination && seatOption == it.seatOption }
            .map(ModelMapper::convertToTrain)
    }

    // Mix booking and train logic to avoid having too much classes
    fun getBookingsByUser(userId: UUID): List<com.qlik.demo.kotlin.model.Booking> {
        return bookingRepository.findByUserId(userId)
            .map(ModelMapper::convertToBooking)
    }
}