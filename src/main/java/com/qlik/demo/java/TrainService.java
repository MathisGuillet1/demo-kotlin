package com.qlik.demo.java;

import com.qlik.demo.java.model.SeatClass;
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

    public List<Train> getTrainByDestination(final String destination, @Nullable final SeatClass seatClass) {
        // For demo purpose (don't filter in memory :scream:)
        return trainRepository.findAll()
                .stream()
                .filter(train -> {
                    if (seatClass != null) {
                        return destination.equals(train.destination()) && seatClass == train.seatClass();
                    } else {
                        return destination.equals(train.destination());
                    }
                })
                .map(TrainService::convert)
                .toList();
    }

    public static Train convert(final TrainDocument trainDocument) {
        return new Train(trainDocument.id(), trainDocument.destination(), trainDocument.seatClass());
    }
}