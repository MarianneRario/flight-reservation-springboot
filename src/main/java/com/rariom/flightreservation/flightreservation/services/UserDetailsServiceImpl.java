package com.rariom.flightreservation.flightreservation.services;

import com.rariom.flightreservation.flightreservation.models.User;
import com.rariom.flightreservation.flightreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // retrieve the user from the database (inject the user repository)
        User user = userRepository.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.getRoles());
    }
}
