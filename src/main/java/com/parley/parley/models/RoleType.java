package com.parley.parley.models;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RoleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roleTypes", fetch = FetchType.EAGER)
    private Set<Instructor> instructors = new HashSet<Instructor>();

    //constructors
    public RoleType(){}

    public RoleType(String role){
        this.role = role;
    }

    //getters

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }


    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }
}
