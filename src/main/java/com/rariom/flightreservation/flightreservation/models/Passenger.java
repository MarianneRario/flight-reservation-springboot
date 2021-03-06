package com.rariom.flightreservation.flightreservation.models;

import javax.persistence.Entity;

@Entity // This certain class will be mapped to database table "FLIGHT"
public class Passenger extends AbstractEntity{

    // the ID will come from the extended class "AbstractEntity.java"
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
