package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
