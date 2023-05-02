package com.rest.cinemaapi;

import com.rest.cinemaapi.enumerators.*;
import com.rest.cinemaapi.models.*;
import com.rest.cinemaapi.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CinemaConfig {
    @PersistenceContext
    EntityManager entityManager;

    @Bean
    CommandLineRunner commandLineRunner(
            SeatRepository seatRepository,
            CinemaHallRepository cinemaHallRepository,
            CinemaRepository cinemaRepository,
            ProgrammeRepository programmeRepository,
            FilmRepository filmRepository
    ) {
        return args -> {
            var address = new Address("Wrocław", "58-303", "Robotnicza", "96");

            var cinema1 = new Cinema("Wrocław Magnolia Park", address);
            var cinema2 = new Cinema("Warszawa Złote Tarasy", address);

            var cinemaHall1 = new CinemaHall("3B", HallType.screen2D, cinema2);
            var cinemaHall2 = new CinemaHall("4A", HallType.screen3D, cinema1);

            var seat1 = new Seat(2, 3, 4, 5, cinemaHall1, SeatSection.A);
            var seat2 = new ForDisabledSeat(1, 3, 2, 3, cinemaHall1, SeatSection.B);
            var seat3 = new Seat(2, 5, 2, 6, cinemaHall1, SeatSection.A);
            var seat4 = new DoubleSeat(7, 7, 7, 8, cinemaHall1, 7, 8, 7, 9, SeatSection.C);
            var doubleSeat5 = new DoubleSeat(4, 5, 4, 5, cinemaHall2, 5, 6, 5, 6, SeatSection.C);

            cinemaHall1.getSeats().addAll(Arrays.asList(seat1, seat2, seat3, seat4, seat1));
            cinemaHall2.getSeats().add(doubleSeat5);

            cinema1.getHalls().add(cinemaHall2);
            cinema2.getHalls().add(cinemaHall1);

            cinemaRepository.save(cinema1);
            cinemaRepository.save(cinema2);

//            cinemaHallRepository.save(cinemaHall1);
//            cinemaHallRepository.save(cinemaHall2);

//            var hall = cinemaHallRepository.findById(1L);
//            var seats = hall.get().getSeats();
//            seats.forEach(System.out::println);
//
//            var seat = seatRepository.findById(2L);
//            System.out.println(seat.get().getCinemaHall().getHallName());

            var cinema = cinemaRepository.findById(1L);
            var x = cinemaRepository.findAllByAddress_CityIs("Wrocław");
            x.forEach(System.out::println);

            var film1 = new Film("x", "x", "x", "x", LocalDate.now(), LocalTime.now(), AgeLimit.PG18, Genre.ACTION, "url");
            var film2 = new Film("y", "y", "y", "y", LocalDate.now(), LocalTime.now(), AgeLimit.PG18, Genre.ACTION, "url");

            filmRepository.saveAll(List.of(film1, film2));

            var programme1 = new Programme(LocalDateTime.now(), film1, cinemaHall1);
            var programme2 = new Programme(LocalDateTime.of(2020, 12, 23, 9, 15), film2, cinemaHall2);
            var programme4 = new Programme(LocalDateTime.of(2020, 12, 23, 9, 15), film1, cinemaHall2);
            var programme3 = new Programme(LocalDateTime.of(2020, 12, 23, 10, 15), film1, cinemaHall2);

            programmeRepository.saveAll(List.of(programme1, programme2, programme3, programme4));

            var contact = new ContactData("Kuba", "W", "500", "500@");

            var reservation1 = new Reservation(contact, ReservationStatus.VALID, programme1);

            var seatRes1 = new ReservedSeat(reservation1, seat1);
            var seatRes2 = new ReservedSeat(reservation1, seat2);


//            entityManager.merge(cinema.get());
//            if (cinema.isPresent()) {
//                System.out.println(cinema.get().getName());
//                System.out.println(Hibernate.isInitialized(cinema.get().getHalls()));
//                cinema.get().getHalls().forEach(System.out::println);
//            }
//            EntityGraph<?> entityGraph = entityManager.getEntityGraph("cinema-with-all-halls");
//            Map<String, Object> properties = new HashMap<>();
//            properties.put("javax.persistence.fetchgraph", entityGraph);
//            var post = entityManager.find(Cinema.class, id, properties);

        };
    }
}
