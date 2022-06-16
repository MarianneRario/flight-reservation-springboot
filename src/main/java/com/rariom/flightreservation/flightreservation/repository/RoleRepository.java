package com.rariom.flightreservation.flightreservation.repository;

import com.rariom.flightreservation.flightreservation.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
