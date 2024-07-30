package com.qlik.demo.java;

import com.qlik.demo.java.model.Booking;
import com.qlik.demo.java.model.SeatOption;
import com.qlik.demo.java.model.Train;
import com.qlik.demo.java.util.ModelMapper;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    private final BookingRepository bookingRepository;

    public TrainService(TrainRepository trainRepository, BookingRepository bookingRepository) {
        this.trainRepository = trainRepository;
        this.bookingRepository = bookingRepository;
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
                .map(ModelMapper::convert)
                .toList();
    }

    // Mix booking and train logic to avoid having too much classes
    public List<Booking> getBookingsByUser(final UUID userId) {
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(ModelMapper::convert)
                .toList();
    }
}