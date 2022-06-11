package com.rariom.flightreservation.flightreservation.controllers;

import com.rariom.flightreservation.flightreservation.models.User;
import com.rariom.flightreservation.flightreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository; // inject this dependency in this class

    // method that will display the registration page to the user
    @RequestMapping(path = "/register")
    protected String showRegistrationPage(){
        return "login/registerUser"; // render a view (registerUser.html) inside login dir
    }

    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
    protected String registerUser(@ModelAttribute("user") User user ){
        // we need a user repository to save the user in the database (inject the dependency "User Repository")
        userRepository.save(user);
        return "login/loginUser"; // render a view (loginUser.html) inside login dir
    }

}
