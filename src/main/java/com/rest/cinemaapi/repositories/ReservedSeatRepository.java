package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.ReservedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Long> {
    List<ReservedSeat> findAllByProgrammeId(Long programmeId);

    Optional<ReservedSeat> findReservedSeatBySeatIdAndProgrammeId(Long seatId, Long programmeId);

}
