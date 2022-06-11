package com.rariom.flightreservation.flightreservation.repository;

import com.rariom.flightreservation.flightreservation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @param email
     * @return single user
     *
     * automatically, spring jpa will generate a query for us
     *
     * SELECT * FROM USER WHERE EMAIL = email
     *
     */
    User findByEmail(String email);
}
