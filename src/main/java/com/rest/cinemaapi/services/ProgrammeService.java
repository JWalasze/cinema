package com.rest.cinemaapi.services;

import com.rest.cinemaapi.enumerators.FilmScreenType;
import com.rest.cinemaapi.enumerators.FilmType;
import com.rest.cinemaapi.enumerators.Filter;
import com.rest.cinemaapi.enumerators.Genre;
import com.rest.cinemaapi.models.Programme;
import com.rest.cinemaapi.repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProgrammeService {
    private final ProgrammeRepository programmeRepository;

    @Autowired
    public ProgrammeService(ProgrammeRepository programmeRepository) {
        this.programmeRepository = programmeRepository;
    }

    public Page<Programme> getProgramme(
            Integer cinemaId,
            Integer page,
            Integer size,
            LocalDate date,
            Filter filter,
            String value
    ) {
        var pageParam = PageRequest.of(page, size, Sort.by("film.name"));
        switch (filter) {
            case NAME -> {
                var name = String.valueOf(value);
                return this.getProgrammeByName(name, date, cinemaId, pageParam);
            }
            case GENRE -> {
                var genre = Genre.valueOf(value);
                return this.getProgrammeByGenre(genre, date, cinemaId, pageParam);
            }
            case TYPE -> {
                var filmType = FilmType.valueOf(value);
                return this.getProgrammeByFilmType(filmType, date, cinemaId, pageParam);
            }
            case SCREENING_TYPE -> {
                var screeningType = FilmScreenType.valueOf(value);
                return this.getProgrammeByScreeningType(screeningType, date, cinemaId, pageParam);
            }
            default -> {
                return this.getProgrammeByDate(date, cinemaId, pageParam);
            }
        }
    }

    private Page<Programme> getProgrammeByName(
            String name,
            LocalDate date,
            Integer cinemaId,
            Pageable pageable
    ) {
        return this.programmeRepository.findAllByFilmNameAndHallCinemaIdAndDateStartsWith(name, cinemaId, date, pageable);
    }

    private Page<Programme> getProgrammeByGenre(
            Genre genre,
            LocalDate date,
            Integer cinemaId,
            Pageable pageable
    ) {
        return this.programmeRepository.findAllByFilmGenreAndHallCinemaIdAndDateStartsWith(genre, cinemaId, date, pageable);
    }

    private Page<Programme> getProgrammeByFilmType(
            FilmType type,
            LocalDate date,
            Integer cinemaId,
            Pageable pageable
    ) {
        return this.programmeRepository.findAllByFilmTypeAndHallCinemaIdAndDateStartsWith(type, cinemaId, date, pageable);
    }

    private Page<Programme> getProgrammeByScreeningType(
            FilmScreenType screeningType,
            LocalDate date,
            Integer cinemaId,
            Pageable pageable
    ) {
        return this.programmeRepository.findAllByFilmScreenTypeAndHallCinemaIdAndDateStartsWith(screeningType, date, cinemaId, pageable);
    }

    private Page<Programme> getProgrammeByDate(
            LocalDate date,
            Integer cinemaId,
            Pageable pageable
    ) {
        return this.programmeRepository.findAllByHallCinemaIdAndDateStartsWith(cinemaId, date, pageable);
    }
}
