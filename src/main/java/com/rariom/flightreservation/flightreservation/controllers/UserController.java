package com.rariom.flightreservation.flightreservation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    // method that will display the registration page to the user
    @RequestMapping(path = "/register")
    public String showRegistrationPage(){
        return "login/registerUser"; // render a view (registerUser.html)
    }

}
