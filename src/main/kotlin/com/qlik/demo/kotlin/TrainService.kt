package com.qlik.demo.kotlin

import com.qlik.demo.kotlin.model.Booking
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
    // Just showcasing
    private val usersById = mapOf(
        "8ab755ba-3db8-4715-bf4e-0627928c2586" to User("Mathis", "mathis@fake.com"),
        "d9163211-4d79-45c4-8ad9-bb35916db86d" to User("John", "john@fake.com")
    )

    fun getTrainByDestination(destination: String, seatOption: SeatOption?): List<Train> {
        // Filtering in memory for the sake of the demo :scream:
        return trainRepository.findAll()
            .filter { destination == it.destination && seatOption == it.seatOption }
            .map(ModelMapper::convertToTrain)
    }

    // Mix booking and train logic to avoid having too much classes
    fun getBookingsByUser(userId: UUID): List<Booking> {
        val userEmail = usersById[userId.toString()]
            ?.email
            ?: throw IllegalStateException("User with id $userId not found")

        if (userEmail.isNotEmpty()) {
            // Do something with user email...
            println("Sending email to user $userEmail")
        }

        return bookingRepository.findByUserId(userId)
            .map(ModelMapper::convertToBooking)
    }
}

data class User(val userId: String, val email: String)