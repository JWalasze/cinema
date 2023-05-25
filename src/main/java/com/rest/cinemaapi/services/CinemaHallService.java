package com.rest.cinemaapi.services;

import com.rest.cinemaapi.models.CinemaHallDTO;
import com.rest.cinemaapi.repositories.CinemaHallRepository;
import com.rest.cinemaapi.repositories.ProgrammeRepository;
import com.rest.cinemaapi.repositories.ReservedSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    private final ReservedSeatRepository reservedSeatRepository;

    private final ProgrammeRepository programmeRepository;

    @Autowired
    public CinemaHallService(CinemaHallRepository cinemaHallRepository,
                             ReservedSeatRepository reservedSeatRepository,
                             ProgrammeRepository programmeRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
        this.reservedSeatRepository = reservedSeatRepository;
        this.programmeRepository = programmeRepository;
    }

    public Optional<CinemaHallDTO> getAllSeatsInHall(Long programmeId) {
        //Sprawdzic ile rzeczy załadowuje
        var programme = this.programmeRepository.findById(programmeId);

        if (programme.isEmpty()) {
            return Optional.empty();
        }

        var cinemaHall = programme.get().getHall();

        //Za dużo requestów do bazy danych
        var reservedSeats = this.reservedSeatRepository.findAllByProgrammeId(programmeId);
        var cinemaHallDTO = new CinemaHallDTO(cinemaHall);
        reservedSeats.forEach(reservedSeat -> cinemaHallDTO.setOccupiedSeats(reservedSeat.getSeat()));

        return Optional.of(cinemaHallDTO);
    }
}
