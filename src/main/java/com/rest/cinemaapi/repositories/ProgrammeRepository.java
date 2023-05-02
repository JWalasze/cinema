package com.rest.cinemaapi.repositories;

import com.rest.cinemaapi.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
}
