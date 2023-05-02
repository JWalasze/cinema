package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(
        name = "film_catalog",
        uniqueConstraints = {@UniqueConstraint(
                name = "unique_film_types",
                columnNames = {"film_language_type", "film_screen_type", "film_type"}
        )}
)
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "director",
            nullable = false
    )
    private String director;

    @Column(
            name = "film_cast",
            nullable = false
    )
    private String cast;

    @Column(
            name = "premiere_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate premiereDate;

    @Column(
            name = "duration",
            nullable = false,
            columnDefinition = "TIME"
    )
    private LocalTime duration;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "age_limit",
            nullable = false
    )
    private AgeLimit ageLimit;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "genre",
            nullable = false
    )
    private Genre genre;

    @Column(
            name = "poster",
            nullable = false
    )
    private String poster;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "film_language_type",
            nullable = false
    )
    private FilmLanguageType filmLanguageType;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "film_screen_type",
            nullable = false
    )
    private FilmScreenType filmScreenType;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "film_type",
            nullable = false
    )
    private FilmType filmType;

    @Column(
            name = "price",
            nullable = false,
            scale = 2
    )
    private BigDecimal price;

    public Film() {
    }

    public Film(
            String name,
            String description,
            String director,
            String cast,
            BigDecimal price,
            LocalDate premiereDate,
            LocalTime duration,
            AgeLimit ageLimit,
            Genre genre,
            String poster,
            FilmLanguageType filmLanguageType,
            FilmScreenType filmScreenType,
            FilmType filmType
    ) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.cast = cast;
        this.price = price;
        this.premiereDate = premiereDate;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.genre = genre;
        this.poster = poster;
        this.filmLanguageType = filmLanguageType;
        this.filmScreenType = filmScreenType;
        this.filmType = filmType;
    }
}
