package com.rariom.flightreservation.flightreservation.services;

import com.rariom.flightreservation.flightreservation.dataTransferObject.ReservationRequest;
import com.rariom.flightreservation.flightreservation.models.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
