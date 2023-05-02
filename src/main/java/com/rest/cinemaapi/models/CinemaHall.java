package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.HallType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema_hall")
@Getter
@Setter
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String hallName;

    @Enumerated(EnumType.STRING)
    @Column(name = "hall_type", nullable = false)
    private HallType hallType;

    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false, foreignKey = @ForeignKey(name = "cinema_fkey"))
    private Cinema cinema;

    public CinemaHall() {
        this.seats = new ArrayList<>();
    }

    public CinemaHall(
            String hallId,
            HallType hallType,
            Cinema cinema
    ) {
        this.hallName = hallId;
        this.hallType = hallType;
        this.cinema = cinema;
        this.seats = new ArrayList<>();
    }
}
