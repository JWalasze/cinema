package com.rest.cinemaapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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

    @JsonInclude(Include.NON_NULL)
    @Column(name = "addition_layout_column")
    private Integer additionSeatColumn;

    @JsonInclude(Include.NON_NULL)
    @Column(name = "addition_layout_row")
    private Integer additionSeatRow;

    @JsonInclude(Include.NON_NULL)
    @Column(name = "addition_column")
    private Integer additionColumn;

    @JsonInclude(Include.NON_NULL)
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
