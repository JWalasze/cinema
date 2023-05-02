package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {}
