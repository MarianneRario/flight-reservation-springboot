package com.rariom.flightreservation.flightreservation.models;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Role extends AbstractEntity{

    private String name;
    private Set<User> users; // a role can be assigned to multiple users

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
