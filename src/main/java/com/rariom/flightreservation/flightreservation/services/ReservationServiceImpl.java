package com.rariom.flightreservation.flightreservation.services;

import com.rariom.flightreservation.flightreservation.dataTransferObject.ReservationRequest;
import com.rariom.flightreservation.flightreservation.models.Flight;
import com.rariom.flightreservation.flightreservation.models.Passenger;
import com.rariom.flightreservation.flightreservation.models.Reservation;
import com.rariom.flightreservation.flightreservation.repository.FlightRepository;
import com.rariom.flightreservation.flightreservation.repository.PassengerRepository;
import com.rariom.flightreservation.flightreservation.repository.ReservationRepository;
import com.rariom.flightreservation.flightreservation.util.EmailUtil;
import com.rariom.flightreservation.flightreservation.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * This class contains business logic for reservation controller
 */
@Component
public class ReservationServiceImpl implements ReservationService{

    // to retrieve the flight object, we need the FlightRepository
    @Autowired
    private FlightRepository flightRepository;

    // to create a passenger, add the passenger repository dependency
    @Autowired
    private PassengerRepository passengerRepository;

    // to create a reservation, add the reservation repository dependency
    @Autowired
    private ReservationRepository reservationRepository;

    // inject the PDFGenerator class
    @Autowired
    private PDFGenerator pdfGenerator;

    // inject the Email utility
    @Autowired
    private EmailUtil emailUtil;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        // make payment
        Long flightId = request.getFlightId();
        Flight flight = flightRepository.findFlightById(flightId); // get the flight by id

        // once we create the flight, let's make the passenger
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        // to create a passenger, inject the passenger repository
        Passenger savedPassenger = passengerRepository.save(passenger);

        // next, let's create a reservation
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        // inject the reservation object to the repository dependency
        Reservation savedReservation = reservationRepository.save(reservation);

        // once you finished saving the reservation, generate an itinerary from savedReservation
        String filepath = "/Users/mapletree/Desktop/ab2b/reservation_pdf/reservation" +savedReservation.getId() + ".pdf";
        pdfGenerator.generateItinerary(savedReservation, filepath);
        // generate email
        emailUtil.sendItinerary(passenger.getEmail(), filepath);
        return savedReservation;
    }
}
