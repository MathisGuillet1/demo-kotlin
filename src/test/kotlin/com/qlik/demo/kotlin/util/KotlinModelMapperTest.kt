package com.qlik.demo.kotlin.util

import com.qlik.demo.kotlin.model.SeatOption
import com.qlik.demo.kotlin.model.TrainDocument
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should not be`
import org.junit.jupiter.api.Test

class KotlinModelMapperTest {

    @Test
    fun `can convert database document to domain model`() {
        val trainDocument = TrainDocument(
            id = "testId",
            destination = "testDestination",
            seatOption = SeatOption.ECONOMY
        )

        val result = ModelMapper.convertToTrain(trainDocument)

        result `should not be` null
        with(result) {
            id `should be equal to` "testId"
            destination `should be equal to` "testDestination"
            seatOption `should be equal to` SeatOption.ECONOMY
        }
    }
}