package com.rariom.flightreservation.flightreservation.controllers;

import com.rariom.flightreservation.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.rariom.flightreservation.flightreservation.models.Flight;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "/findFlights", method = RequestMethod.POST)
    protected String findFlight(@RequestParam("from") String from,
                             @RequestParam("to") String to,
                             @RequestParam("departureDate")
                                 @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate,
                             ModelMap modelMap){

        // once entered, it will search for the flight using flight repository
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        return "displayFlights"; // return the displayFlights.html view
    }

    // method that will allow the admin user to create a flight
    @RequestMapping("/admin/showAddFlight")
    protected String showAddFlight(){
        return "addFlight";
    }
}
