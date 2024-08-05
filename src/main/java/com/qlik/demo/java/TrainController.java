package com.qlik.demo.java;

import com.qlik.demo.java.model.Booking;
import com.qlik.demo.java.model.SeatOption;
import com.qlik.demo.java.model.Train;
import com.qlik.demo.java.util.TokenUtil;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trains")
public class TrainController {

    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    // Find all trains with given destination and optionally filtered on seat option
    @GetMapping
    public List<Train> getTrainsByDestination(
            @RequestParam @NotNull final String destination,
            @RequestParam @Nullable final String seatOptionParam
    ) {
        logger.info("Fetching trains with destination {} and seat option {}", destination, seatOptionParam);

        final var seatOption = seatOptionParam != null
                ? SeatOption.from(seatOptionParam).orElse(null)
                : null;

        return trainService.getTrainByDestination(destination, seatOption);
    }

    @GetMapping("/bookings")
    public List<Booking> getUserBookings() {
        final var userId = TokenUtil.extractUserId()
                .orElseThrow(() -> new IllegalArgumentException("Unable to extract user id from token"));

        return trainService.getBookingsByUser(userId);
    }
}
