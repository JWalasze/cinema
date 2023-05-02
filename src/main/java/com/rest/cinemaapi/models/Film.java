package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.AgeLimit;
import com.rest.cinemaapi.enumerators.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "film_catalog")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "film_cast", nullable = false)
    private String cast;

    @Column(name = "premiere_date", nullable = false, columnDefinition = "DATE")
    private LocalDate premiereDate;

    @Column(name = "duration", nullable = false, columnDefinition = "TIME")
    private LocalTime duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_limit", nullable = false)
    private AgeLimit ageLimit;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;

    @Column(name = "poster", nullable = false)
    private String poster;

    public Film() {
    }

    public Film(
            String name,
            String description,
            String director,
            String cast,
            LocalDate premiereDate,
            LocalTime duration,
            AgeLimit ageLimit,
            Genre genre,
            String poster
    ) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.cast = cast;
        this.premiereDate = premiereDate;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.genre = genre;
        this.poster = poster;
    }
}
