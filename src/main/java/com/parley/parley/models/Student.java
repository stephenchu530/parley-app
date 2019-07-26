package com.parley.parley.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@DynamoDBTable(tableName = "students")
public class Student implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    String firstname;
    String lastname;
    String email;
    String classDesignator;

    @Column(unique = true)
    String username;
    String password;

    //Default Constructor
    public Student(){}

    public Student(String firstname, String lastname, String username, String password, String classDesignator, String email){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
        this.classDesignator=classDesignator;
        this.email=email;
    }

    //Getters
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public UUID getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getFirstname() {
        return firstname;
    }

    @DynamoDBAttribute
    public String getLastname() {
        return lastname;
    }

    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }

    @DynamoDBAttribute
    public String getClassDesignator() {
        return classDesignator;
    }

    @Override
    @DynamoDBAttribute
    public String getUsername() {
        return username;
    }

    @Override
    @DynamoDBAttribute
    public String getPassword() {
        return password;
    }

    //Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClassDesignator(String classDesignator) {
        this.classDesignator = classDesignator;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}