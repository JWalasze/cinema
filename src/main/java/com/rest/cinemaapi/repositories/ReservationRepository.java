package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
