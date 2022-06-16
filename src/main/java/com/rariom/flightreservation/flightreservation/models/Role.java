package com.rariom.flightreservation.flightreservation.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {

    private String name;
    @ManyToMany(mappedBy = "roles") // this tells that the mapping needs to be looked on the other side of the relationshp
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

    @Override
    public String getAuthority() {
        return name; // return the name of the role
    }
}
