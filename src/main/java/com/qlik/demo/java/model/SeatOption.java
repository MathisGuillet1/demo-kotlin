package com.qlik.demo.java.model;

import java.util.Arrays;
import java.util.Optional;

public enum SeatOption {
    ECONOMY("Economy"),
    FIRST_CLASS("First Class");

    private final String optionName;

    SeatOption(String optionName) {
        this.optionName = optionName;
    }

    // Reverse lookup
    public static Optional<SeatOption> get(final String name) {
        return Arrays.stream(SeatOption.values())
                .filter(seatClass -> seatClass.optionName.equals(name))
                .findFirst();
    }
}
