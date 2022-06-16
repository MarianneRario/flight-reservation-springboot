package com.rariom.flightreservation.flightreservation.controllers;

import com.rariom.flightreservation.flightreservation.models.User;
import com.rariom.flightreservation.flightreservation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository; // inject this dependency in this class

    // method that will display the registration page to the user
    @RequestMapping(path = "/registerPage")
    protected String showRegistrationPage(){
        return "login/registerUser"; // render a view (registerUser.html) inside login dir
    }

    // redirected to the registration page
    @RequestMapping(path = "/registered", method = RequestMethod.POST) // we should create a card here saying that the user successfully registered
    protected String registerUser(@ModelAttribute("user") User user, ModelMap modelMap ){
        // we need a user repository to save the user in the database (inject the dependency "User Repository")
        userRepository.save(user);
        modelMap.addAttribute("message", "Successfully registered");

        return "login/registerUser"; // render a view (loginUser.html) inside login dir
    }

    // redirected to the login page
    @RequestMapping("/loginPage")
    protected String showLoginPage(){
        return "login/loginUser";
    }

    // login user method with Logger implementation
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    protected String loginUser(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               ModelMap modelMap){  // we need to bind the request parameters to email and password by using @RequestParam

        // find the user
        User user = userRepository.findByEmail(email);

        if(user.getPassword().equals(password)) { // compare the password in the database with the password the user entered

            return "findFlights"; // if it matches, return a different view back to the user (findFlights.html)
        } else {
            // we will return a message back using the model map
            String msg = "Incorrect credentials. Please try again.";
            modelMap.addAttribute("message", msg);
        }
        return "login/loginUser"; // if the user enters incorrect credentials, we will redirect the user to login.html view
    }





}
