package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides(
            {@AttributeOverride(
                    name = "firstName",
                    column = @Column(
                            name = "first_name",
                            nullable = false
                    )
            ), @AttributeOverride(
                    name = "lastName",
                    column = @Column(
                            name = "last_name",
                            nullable = false
                    )
            ), @AttributeOverride(
                    name = "phoneNumber",
                    column = @Column(
                            name = "phone_number",
                            nullable = false
                    )
            ), @AttributeOverride(
                    name = "email",
                    column = @Column(
                            name = "email",
                            nullable = false
                    )
            )}
    )
    private ContactData contactData;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "reservation_status",
            nullable = false
    )
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(
            name = "programme_film",
            nullable = false,
            foreignKey = @ForeignKey(name = "programme_film_fkey")
    )
    private Programme programmeFilm;

    @OneToMany(
            mappedBy = "reservation",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<ReservedSeat> reservedSeats;

    public Reservation() {
        this.reservedSeats = new ArrayList<>();
    }

    public Reservation(
            ContactData contactData,
            Programme programmeFilm
    ) {
        this.contactData = contactData;
        this.reservationStatus = ReservationStatus.VALID;
        this.programmeFilm = programmeFilm;
        this.reservedSeats = new ArrayList<>();
    }
}
