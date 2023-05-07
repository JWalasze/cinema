package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.enumerators.FilmScreenType;
import com.rest.cinemaapi.enumerators.FilmType;
import com.rest.cinemaapi.enumerators.Genre;
import com.rest.cinemaapi.models.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
    @EntityGraph(
            value = "full-programme",
            type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("select programme from Programme programme where CAST(programme.date as localdate) = :date and programme.hall.cinema.id = :cinemaId")
    Page<Programme> findAllByHallCinemaIdAndDateStartsWith(
            Integer cinemaId,
            LocalDate date,
            Pageable pageable
    );

    @EntityGraph(
            value = "full-programme",
            type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("select programme from Programme programme where CAST(programme.date as localdate) = :date and programme.hall.cinema.id = :cinemaId and programme.film.name = :name")
    Page<Programme> findAllByFilmNameAndHallCinemaIdAndDateStartsWith(
            String name,
            Integer cinemaId,
            LocalDate date,
            Pageable pageable
    );

    @EntityGraph(
            value = "full-programme",
            type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("select programme from Programme programme where CAST(programme.date as localdate) = :date and programme.hall.cinema.id = :cinemaId and programme.film.genre = :genre")
    Page<Programme> findAllByFilmGenreAndHallCinemaIdAndDateStartsWith(
            Genre genre,
            Integer cinemaId,
            LocalDate date,
            Pageable pageable
    );

    @EntityGraph(
            value = "full-programme",
            type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("select programme from Programme programme where CAST(programme.date as localdate) = :date and programme.hall.cinema.id = :cinemaId and programme.film.type = :filmType")
    Page<Programme> findAllByFilmTypeAndHallCinemaIdAndDateStartsWith(
            FilmType filmType,
            Integer cinemaId,
            LocalDate date,
            Pageable pageable
    );


    @EntityGraph(
            value = "full-programme",
            type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("select programme from Programme programme where CAST(programme.date as localdate) = :date and programme.hall.cinema.id = :cinemaId and programme.film.screenType = :filmScreenType")
    Page<Programme> findAllByFilmScreenTypeAndHallCinemaIdAndDateStartsWith(
            FilmScreenType filmScreenType,
            LocalDate date,
            Integer cinemaId,
            Pageable pageable
    );
}
