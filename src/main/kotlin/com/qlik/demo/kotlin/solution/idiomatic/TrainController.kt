package com.qlik.demo.kotlin.solution.idiomatic

import com.qlik.demo.kotlin.solution.idiomatic.model.SeatOption
import com.qlik.demo.kotlin.solution.idiomatic.model.Train
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("trains")
class TrainController(private val trainService: TrainService) {

    @GetMapping
    fun getTrainsByDestination(
        @RequestParam destination: String,
        @RequestParam seatOptionParam: String?
    ): List<Train> {
        val seatOption = seatOptionParam?.let { SeatOption.get(seatOptionParam) }

        return trainService.getTrainByDestination(destination, seatOption)
    }
}