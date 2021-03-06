package com.rariom.flightreservation.flightreservation.controllers;

import com.rariom.flightreservation.flightreservation.models.User;
import com.rariom.flightreservation.flightreservation.repository.UserRepository;
import com.rariom.flightreservation.flightreservation.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // a controller class must be annotated by @Controller
public class UserController {

    @Autowired
    private UserRepository userRepository; // inject this dependency in this class

    @Autowired
    private BCryptPasswordEncoder encoder; // inject this dependency

    @Autowired
    private SecurityService securityService; // inject this dependency for secure login

    // method that will display the registration page to the user
    @RequestMapping(path = "/registerPage")
    protected String showRegistrationPage(){
        return "login/registerUser"; // render a view (registerUser.html) inside login dir
    }

    // redirected to the registration page
    // we should create a card here saying that the user successfully registered
    @RequestMapping(path = "/registered", method = RequestMethod.POST)
    protected String registerUser(@ModelAttribute("user") User user, ModelMap modelMap ){
        // before saving the user in the db, we must encode the password first using BCrypt password encoder
        user.setPassword(encoder.encode(user.getPassword()));
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
        // User user = userRepository.findByEmail(email); -> replaced this with login() from SecurityService interface

        boolean loginResponse = securityService.login(email, password);

        if(loginResponse) { // compare the password in the database with the password the user entered

            return "findFlights"; // if it matches, return a different view back to the user (findFlights.html)
        } else {
            // we will return a message back using the model map
            String msg = "Incorrect credentials. Please try again.";
            modelMap.addAttribute("message", msg);
        }
        return "login/loginUser"; // if the user enters incorrect credentials, we will redirect the user to login.html view
    }





}
