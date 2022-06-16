package com.rariom.flightreservation.flightreservation.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * every common fields across our entities/models (User.java, Flight.java, Passenger.java, Reservation.java)
 * will go here in AbstractEntity class.
 * All of these model classes has "id" attribute that must not be repeated even their annotations:
 *     @Id
 *     @GeneratedValue(strategy)
 *     private Long id;
 */

@MappedSuperclass // acts as a parent class to other entities
public class AbstractEntity {
    @Id // always put this mark in primary key such as id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means that it auto generates
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
