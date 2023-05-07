package com.rest.cinemaapi.services;

import com.rest.cinemaapi.models.Cinema;
import com.rest.cinemaapi.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> findAllCinemas() {
        return this.cinemaRepository.findAll();
    }
}
