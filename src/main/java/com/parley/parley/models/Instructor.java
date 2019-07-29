package com.parley.parley.models;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;

    @Column(unique = true)
    private String username;
    private String password;

    List<String> classes;


    //getters


    public UUID getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public List<String> getClasses() {
        return classes;
    }


    //setters

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }
}
