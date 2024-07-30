package com.qlik.demo.java.util;

import com.qlik.demo.java.model.TrainDocument;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JavaModelMapperTest {

    @Test
    void canConvertDatabaseDocumentToDomainModel() {
        final var trainDocument = new TrainDocument(
                "testId",
                "testDestination",
                null
        );

        final var result = ModelMapper.convert(trainDocument);

        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo("testId");
        assertThat(result.destination()).isEqualTo("testDestination");
        assertThat(result.seatOption()).isNull();
    }
}