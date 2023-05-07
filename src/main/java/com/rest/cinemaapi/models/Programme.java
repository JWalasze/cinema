package com.rest.cinemaapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@NamedEntityGraph(
        name = "full-programme",
        attributeNodes = {@NamedAttributeNode("film"), @NamedAttributeNode(
                value = "hall",
                subgraph = "programme.cinema"
        )},
        subgraphs = {@NamedSubgraph(
                name = "programme.cinema",
                attributeNodes = @NamedAttributeNode("cinema")
        )}
)
@Entity
@Table(
        name = "programme",
        uniqueConstraints = {@UniqueConstraint(
                name = "unique_hall_film_date",
                columnNames = {"film_id", "hall_id", "date"}
        )}
)
@Getter
@Setter
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "date",
            nullable = false
    )
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(
            name = "film_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "film_fkey")
    )
    private Film film;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "hall_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "screening_hall_fkey")
    )
    private CinemaHall hall;

    public Programme() {
    }

    public Programme(
            LocalDateTime date,
            Film film,
            CinemaHall hall
    ) {
        this.date = date;
        this.film = film;
        this.hall = hall;
    }
}
