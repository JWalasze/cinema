package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
//    @EntityGraph(
//            value = "cinema-halls-with-all-seats",
//            type = EntityGraph.EntityGraphType.LOAD
//    )
//    Optional<CinemaHall> findById(Long id);
}
