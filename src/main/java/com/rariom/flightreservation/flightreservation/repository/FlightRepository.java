package com.rariom.flightreservation.flightreservation.repository;

import com.rariom.flightreservation.flightreservation.models.Flight;
import com.rariom.flightreservation.flightreservation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("from Flight where departureCity=:departureCity " +
            "and arrivalCity=:arrivalCity and departureDate=:departureDate")
    List<Flight> findFlights(@Param("departureCity") String from,
                             @Param("arrivalCity") String to,
                             @Param("departureDate")Date departureDate); // return a list of flights
}
