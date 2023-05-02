package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.SeatSection;
import com.rest.cinemaapi.enumerators.SeatType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ForDisabledSeat extends Seat {
    public ForDisabledSeat() {
        super();
    }

    public ForDisabledSeat(
            Integer layoutColumn,
            Integer layoutRow,
            Integer column,
            Integer row,
            CinemaHall cinemaHall,
            SeatSection seatSection
    ) {
        super(layoutColumn, layoutRow, column, row, cinemaHall, seatSection);
        this.setSeatType(SeatType.DISABLED);
    }
}
