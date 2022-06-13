package com.rariom.flightreservation.flightreservation.controllers;

import com.rariom.flightreservation.flightreservation.dataTransferObject.ReservationRequest;
import com.rariom.flightreservation.flightreservation.models.Flight;
import com.rariom.flightreservation.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    // url came from displayFlights.html
    // (<td><a th:href="@{'showCompleteReservation?flightId='+${flight.id}}">Select</a></td>)
    @RequestMapping(path = "/showCompleteReservation")
    protected String showReservationPage(@RequestParam("flightId") Long flightId, ModelMap modelMap){

        // retrieve the flight using the flight repository
        Flight flight = flightRepository.findFlightById(flightId); // custom method in FlightRepository interface
        modelMap.addAttribute("flight", flight);
        return "completeReservation"; // render the view

    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    protected String completeReservation(ReservationRequest request){

        return "";
    }
}
