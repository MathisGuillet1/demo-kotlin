package com.qlik.demo.java.model;

public record Train(
        String id,
        String destination,
        SeatOption seatOption
) {
}
