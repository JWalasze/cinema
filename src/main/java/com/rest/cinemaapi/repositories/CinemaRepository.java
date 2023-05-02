package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.Cinema;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    @EntityGraph(value = "cinema-with-all-halls", type = EntityGraph.EntityGraphType.LOAD)
    List<Cinema> findAllByAddress_CityIs(String id);

}
