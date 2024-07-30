package com.qlik.demo.kotlin.util

import com.qlik.demo.kotlin.model.SeatOption
import com.qlik.demo.kotlin.model.TrainDocument
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBe
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

        result shouldNotBe null
        with(result) {
            id shouldBeEqualTo "testId"
            destination shouldBeEqualTo "testDestination"
            seatOption shouldBeEqualTo SeatOption.ECONOMY
        }
    }
}