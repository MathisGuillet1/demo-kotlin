package com.qlik.demo.kotlin

import com.qlik.demo.kotlin.model.Booking
import com.qlik.demo.kotlin.model.SeatOption
import com.qlik.demo.kotlin.model.Train
import com.qlik.demo.kotlin.util.TokenUtil
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("trains")
class TrainController(private val trainService: TrainService) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun getTrainsByDestination(
        @RequestParam destination: String,
        @RequestParam seatOptionParam: String?
    ): List<Train> {
        logger.info("Fetching trains with destination $destination and seat option $seatOptionParam")

        val seatOption = seatOptionParam?.let { SeatOption.get(seatOptionParam) }

        return trainService.getTrainByDestination(destination, seatOption)
    }

    @GetMapping("/bookings")
    fun getUserBookings(): List<Booking> {
        val userId = TokenUtil.extractUserId() ?: throw IllegalStateException("Cannot extract user id from token")

        return trainService.getBookingsByUser(userId)
    }
}