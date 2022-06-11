package com.rariom.flightreservation.flightreservation.repository;

import com.rariom.flightreservation.flightreservation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
