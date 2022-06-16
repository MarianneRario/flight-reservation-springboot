package com.rariom.flightreservation.flightreservation.models;

import javax.persistence.*;
import java.util.Set;

@Entity //  specifies that the class is an entity and is mapped to a database table
public class User extends AbstractEntity{

    // the ID will come from the extended class "AbstractEntity.java"
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name="user_role", // table that joins the "User" and "Role" table
            joinColumns = @JoinColumn(name="user_id"), // @JoinColumn specified the reference of the id (fk)
            inverseJoinColumns = @JoinColumn(name = "role_id")) // inverseJoinColumns specified the other reference id (fk)
    private Set<Role> roles; // a user can have multiple roles

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
