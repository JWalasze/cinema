package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Long> {}
