package com.qlik.demo.kotlin.util

import com.qlik.demo.kotlin.model.SeatOption
import com.qlik.demo.kotlin.model.TrainDocument
import org.assertj.core.api.Assertions.assertThat
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

        assertThat(result).isNotNull()
        assertThat(result.id).isEqualTo("testId")
        assertThat(result.destination).isEqualTo("testDestination")
        assertThat(result.seatOption).isEqualTo(SeatOption.ECONOMY)
    }
}