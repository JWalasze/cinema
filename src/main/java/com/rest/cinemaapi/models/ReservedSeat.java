package com.rest.cinemaapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reserved_seat")
@Getter
@Setter
public class ReservedSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "reservation_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "reservation_fkey")
    )
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(
            name = "reserved_seat_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "reserved_seat_id")
    )
    private Seat reservedSeat;

    public ReservedSeat() {
    }

    public ReservedSeat(
            Reservation reservation,
            Seat reservedSeat
    ) {
        this.reservation = reservation;
        this.reservedSeat = reservedSeat;
    }
}
