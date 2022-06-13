package com.rariom.flightreservation.flightreservation.repository;

import com.rariom.flightreservation.flightreservation.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findReservationById(Long id); // return reservation
}
