package com.rest.cinemaapi.models;

import com.rest.cinemaapi.enumerators.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmCharacteristics {
    List<FilmLanguageType> filmLanguageTypes;

    List<FilmScreenType> filmScreenTypes;

    List<FilmType> filmTypes;

    List<Filter> filters;

    List<Genre> genres;

    List<HallType> hallTypes;

    List<SeatSection> seatSections;

    List<SeatType> seatTypes;

    public FilmCharacteristics() {
        this.filmLanguageTypes = List.of(FilmLanguageType.values());
        this.filmScreenTypes = List.of(FilmScreenType.values());
        this.filmTypes = List.of(FilmType.values());
        this.filters = List.of(Filter.values());
        this.genres = List.of(Genre.values());
        this.hallTypes = List.of(HallType.values());
        this.seatSections = List.of(SeatSection.values());
        this.seatTypes = List.of(SeatType.values());
    }
}
