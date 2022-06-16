package com.rariom.flightreservation.flightreservation.services;

import com.rariom.flightreservation.flightreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public boolean login(String username, String password) {
        // fetch the user using user service (inject UserDetailService interface)
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // once we already fetched the userDetails, create a username and password authentication token
        // we can do this by instantiating username and password token
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        // inject authentication manager
        authenticationManager.authenticate(token);

        // retrieve the state of the login
        boolean authenticated = token.isAuthenticated();

        // send the token to security context holder
        if (authenticated){
            // spring will store this information, and it will not keep on asking username and password
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return authenticated;
    }
}
