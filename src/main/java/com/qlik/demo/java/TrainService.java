package com.qlik.demo.java;

import com.qlik.demo.java.model.SeatOption;
import com.qlik.demo.java.model.Train;
import com.qlik.demo.java.model.TrainDocument;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> getTrainByDestination(final String destination, @Nullable final SeatOption seatOption) {
        // Filtering in memory for the sake of the demo :scream:
        return trainRepository.findAll()
                .stream()
                .filter(train -> {
                    if (seatOption != null) {
                        return destination.equals(train.destination()) && seatOption == train.seatOption();
                    } else {
                        return destination.equals(train.destination());
                    }
                })
                .map(TrainService::convert)
                .toList();
    }

    public static Train convert(final TrainDocument document) {
        return new Train(
                document.id(),
                document.destination(),
                document.seatOption()
        );
    }
}