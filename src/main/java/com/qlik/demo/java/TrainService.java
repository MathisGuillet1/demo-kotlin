package com.qlik.demo.java;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Optional<Train> getTrainByDestination(final String destination) {
        // For demo purpose (don't filter in memory :scream:)
        return trainRepository.findAll()
                .stream()
                .filter(train -> destination.equals(train.destination()))
                .findFirst()
                .map(TrainService::convert);
    }

    public static Train convert(final TrainDocument trainDocument) {
        return new Train(trainDocument.id(), trainDocument.destination());
    }
}