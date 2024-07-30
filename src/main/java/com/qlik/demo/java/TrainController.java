package com.qlik.demo.java;

import com.qlik.demo.java.model.SeatOption;
import com.qlik.demo.java.model.Train;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trains")
public class TrainController {

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
        final var seatOption = seatOptionParam != null ? SeatOption.get(seatOptionParam).orElse(null) : null;

        return trainService.getTrainByDestination(destination, seatOption);
    }
}
