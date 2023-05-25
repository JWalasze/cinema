package com.rest.cinemaapi.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpecifiedSeat {
    private Seat seat;

    private Boolean isOccupied;

    public SpecifiedSeat(Seat seat) {
        this.seat = seat;
        this.isOccupied = false;
    }
}
