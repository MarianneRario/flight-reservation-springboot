package com.rariom.flightreservation.flightreservation.controllers;

import com.rariom.flightreservation.flightreservation.dataTransferObject.ReservationUpdateRequest;
import com.rariom.flightreservation.flightreservation.models.Reservation;
import com.rariom.flightreservation.flightreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReservationRESTController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Optional<Reservation> findReservation(@PathVariable("id") Long id){
        // use the id and fetch the reservation from the db by injecting here the ReservationRepository

        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation;
    }

    // we are passing ReservationUpdateRequest request (a class) because we don't want to pass the entire Reservation to this update method
    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        // retrieve the reservation from the database and then perform an update
        Reservation reservation = reservationRepository.findReservationById(request.getId());
        reservation.setLuggageQuantity(request.getLuggageQuantity());
        reservation.setCheckedIn(request.isCheckedIn());

        // save the updated reservation
        return reservationRepository.save(reservation);
    }
}
