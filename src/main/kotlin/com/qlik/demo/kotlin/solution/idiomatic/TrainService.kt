package com.qlik.demo.kotlin.solution.idiomatic

import com.qlik.demo.kotlin.solution.idiomatic.model.SeatOption
import com.qlik.demo.kotlin.solution.idiomatic.model.Train
import com.qlik.demo.kotlin.solution.idiomatic.model.TrainDocument
import org.springframework.stereotype.Service

@Service
class TrainService(private val trainRepository: TrainRepository) {

    fun getTrainByDestination(destination: String, seatOption: SeatOption?): List<Train> {
        // Filtering in memory for the sake of the demo :scream:
        return trainRepository.findAll()
            .filter { destination == it.destination && seatOption == it.seatOption }
            .map(::convert)
    }

    companion object {
        private fun convert(document: TrainDocument) =
            Train(
                id = document.id,
                destination = document.destination,
                seatOption = document.seatOption
            )
    }
}