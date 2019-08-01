package com.parley.parley.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany
    private List<Schedules> interviewSchedule;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> listOfAssessments;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> classes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "AdminRoles",
            joinColumns = @JoinColumn(
                    name = "instructor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<RoleType> roleTypes = new HashSet<RoleType>();

    public boolean isAdmin() {
        List<String> roleNames = new ArrayList<String>();
        roleTypes.forEach(roleType -> roleNames.add(roleType.getRole()));
        if(roleNames.contains("admin")) {
            return true;
        } else {
            return false;
        }
    }

    //instance variable for student users
    private String classDesignator;

    //constructors for admin/instructor users
    public UserAccount(){}

    public UserAccount(
            String firstName,
            String lastName,
            String username,
            String password,
            String email){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setInterviewSchedule(new ArrayList<Schedules>());
        this.setListOfAssessments(new ArrayList<String>());
    }

    //constructors for student users
    public UserAccount(String firstName,
                       String lastName,
                       String username,
                       String password,
                       String classDesignator,
                       String email){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUsername(username);
        this.setPassword(password);
        this.setClassDesignator(classDesignator);
        this.setEmail(email);
    }

    //getters


    public Long getId() {
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

    public String getClassDesignator() {
        return classDesignator;
    }

    public List<Schedules> getInterviewSchedule() {
        return interviewSchedule;
    }

    public List<String> getListOfAssessments() {
        return listOfAssessments;
    }

    //users details service methods
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getPassword() {
        return password;
    }


    public List<String> getClasses() {
        return classes;
    }

    public Set<RoleType> getRoleTypes() {
        return roleTypes;
    }

    //setters

    public void setId(Long id) {
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

    public void setRoleTypes(Set<RoleType> roleTypes) {
        this.roleTypes = roleTypes;
    }

    public void setClassDesignator(String classDesignator) {
        this.classDesignator = classDesignator;
    }

    public void setInterviewSchedule(List<Schedules> interviewerSchedule) {
        this.interviewSchedule = interviewerSchedule;
    }

    public void setListOfAssessments(List<String> listOfAssessments) {
        this.listOfAssessments = listOfAssessments;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roleTypes.forEach(roleType -> roles.add(new SimpleGrantedAuthority("role_" + roleType.getRole())));
        return roles;
    }

}
