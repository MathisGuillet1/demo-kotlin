package com.qlik.demo.java;

import com.qlik.demo.java.model.Booking;
import com.qlik.demo.java.model.SeatOption;
import com.qlik.demo.java.model.Train;
import com.qlik.demo.java.util.ModelMapper;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    private final BookingRepository bookingRepository;

    // Just showcasing
    private static final Map<String, User> usersById = Map.of(
            "8ab755ba-3db8-4715-bf4e-0627928c2586",
            new User("Mathis", "mathis@fake.com"),
            "d9163211-4d79-45c4-8ad9-bb35916db86d",
            new User("John", "john@fake.com")
    );

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
        final var userEmail = Optional.ofNullable(usersById.get(userId.toString()))
                .map(User::email)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " was not found"));

        if (userEmail != null && !userEmail.isEmpty()) {
            // Do something with user email...
            System.out.println(userEmail);
        }

        return bookingRepository.findByUserId(userId)
                .stream()
                .map(ModelMapper::convert)
                .toList();
    }
}

record User(String name, String email) {
}