package com.rariom.flightreservation.flightreservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity // This certain class will be mapped to database table "FLIGHT"
public class Reservation extends AbstractEntity{

    // the ID will come from the extended class "AbstractEntity.java"
    private boolean checkedIn;
    @Column(name = "NUMBER_OF_BAGS")
    private int luggageQuantity;
    @OneToOne // dictates that reservation and passenger has a one-to-one relationship
    private Passenger passenger; // fk relationship
    @OneToOne // dictates that reservation and passenger has a one-to-one relationship
    private Flight flight; // fk relationship


    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getLuggageQuantity() {
        return luggageQuantity;
    }

    public void setLuggageQuantity(int luggageQuantity) {
        this.luggageQuantity = luggageQuantity;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
