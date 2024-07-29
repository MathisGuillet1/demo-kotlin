package com.qlik.demo.java.model;

import java.util.Arrays;
import java.util.Optional;

public enum SeatClass {
    ECONOMY("Economy"),
    FIRST_CLASS("First Class");

    private final String name;

    SeatClass(String name) {
        this.name = name;
    }

    public static Optional<SeatClass> get(final String name) {
        return Arrays.stream(SeatClass.values())
                .filter(seatClass -> seatClass.name.equals(name))
                .findFirst();
    }
}
