package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.HallType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class CinemaHallDTO {
    private Long id;

    private String hallName;

    private HallType hallType;

    private Integer numberOfSeats;

    private List<SpecifiedSeat> seats;

    public CinemaHallDTO(CinemaHall cinemaHall) {
        this.id = cinemaHall.getId();
        this.hallName = cinemaHall.getHallName();
        this.hallType = cinemaHall.getHallType();
        this.numberOfSeats = cinemaHall.getNumberOfSeats();
        this.seats = new ArrayList<>();

        cinemaHall.getSeats().forEach(this::addNewSeat);
    }

    private void addNewSeat(Seat seat) {
        this.seats.add(new SpecifiedSeat(seat));
    }

    public void setOccupiedSeats(Seat seat) {
        for (SpecifiedSeat specifiedSeat : this.seats) {
            if (Objects.equals(specifiedSeat.getSeat(), seat)) {
                var index = this.seats.indexOf(specifiedSeat);
                if (index == -1) {
                    return;
                }
                this.seats.get(index).setIsOccupied(true);
                break;
            }
        }
    }
}
