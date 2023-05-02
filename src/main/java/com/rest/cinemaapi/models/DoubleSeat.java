package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.SeatSection;
import com.rest.cinemaapi.enumerators.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DoubleSeat extends Seat {

    @Column(name = "addition_layout_column")
    private Integer additionSeatColumn;

    @Column(name = "addition_layout_row")
    private Integer additionSeatRow;

    @Column(name = "addition_column")
    private Integer additionColumn;

    @Column(name = "addition_row")
    private Integer additionRow;

    public DoubleSeat() {
        super();
    }

    public DoubleSeat(
            Integer layoutColumn,
            Integer layoutRow,
            Integer column,
            Integer row,
            CinemaHall cinemaHall,
            Integer additionSeatColumn,
            Integer additionSeatRow,
            Integer additionColumn,
            Integer additionRow,
            SeatSection seatSection
    ) {
        super(layoutColumn, layoutRow, column, row, cinemaHall, seatSection);
        this.additionSeatColumn = additionSeatColumn;
        this.additionSeatRow = additionSeatRow;
        this.additionColumn = additionColumn;
        this.additionRow = additionRow;
        this.setSeatType(SeatType.DOUBLE);
    }
}
