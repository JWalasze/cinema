package com.rest.cinemaapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "reserved_seat",
        uniqueConstraints = {@UniqueConstraint(
                name = "unique_programme_seat",
                columnNames = {"reserved_seat_id", "programme_id"}
        )}
)
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
            foreignKey = @ForeignKey(name = "reserved_seat_fkey")
    )
    private Seat reservedSeat;

    @ManyToOne
    @JoinColumn(
            name = "programme_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "programme_fkey")
    )
    private Programme programme;

    public ReservedSeat() {
    }

    public ReservedSeat(
            Reservation reservation,
            Seat reservedSeat,
            Programme programme
    ) {
        this.reservation = reservation;
        this.reservedSeat = reservedSeat;
        this.programme = programme;
    }
}
