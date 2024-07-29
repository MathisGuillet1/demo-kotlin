package com.qlik.demo.java;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public Train getTrainByName(@RequestParam @NotNull final String name) {
        return trainService.getTrainByDestination(name)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No train with name " + name + " could be found"));
    }
}
