package com.qlik.demo.java.util;

import com.qlik.demo.java.model.Booking;
import com.qlik.demo.java.model.BookingDocument;
import com.qlik.demo.java.model.Train;
import com.qlik.demo.java.model.TrainDocument;

public class ModelMapper {

    private ModelMapper() {
    }

    public static Train convert(final TrainDocument document) {
        return new Train(
                document.id(),
                document.destination(),
                document.seatOption()
        );
    }

    public static Booking convert(final BookingDocument document) {
        return new Booking(
                document.id(),
                document.userId(),
                document.destination(),
                document.bookingDate()
        );
    }
}
