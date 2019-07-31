package com.parley.parley.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne
    UserAccount studentOne;
    Long promptOne;
    @OneToOne
    UserAccount studentTwo;
    Long promptTwo;
    Boolean doneOne;
    Boolean doneTwo;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date dueDateOfInterview;

    //Default Constructor
    public Schedules() {}

    public Schedules(UserAccount studentOne,
                     Long promptOne,
                     UserAccount studentTwo,
                     Long promptTwo,
                     Date dueDateOfInterview) {
        this.setStudentOne(studentOne);
        this.setPromptOne(promptOne);
        this.setStudentTwo(studentTwo);
        this.setPromptTwo(promptTwo);
        this.setDueDateOfInterview(dueDateOfInterview);
        this.setDoneOne(false);
        this.setDoneTwo(false);
    }
    // Getters
    public Long getId() {
        return id;
    }

    public UserAccount getStudentOne() {
        return studentOne;
    }

    public Long getPromptOne() {
        return promptOne;
    }

    public UserAccount getStudentTwo() {
        return studentTwo;
    }

    public Long getPromptTwo() {
        return promptTwo;
    }

    public Date getDueDateOfInterview() {
        return dueDateOfInterview;
        }

    public Boolean getDoneOne() {
        return doneOne;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentOne(UserAccount studentOne) {
        this.studentOne = studentOne;
    }

    public void setPromptOne(Long promptOne) {
        this.promptOne = promptOne;
    }

    public void setStudentTwo(UserAccount studentTwo) {
        this.studentTwo = studentTwo;
    }

    public void setPromptTwo(Long promptTwo) {
        this.promptTwo = promptTwo;
    }

    public void setDueDateOfInterview(Date dueDateOfInterview) {
        this.dueDateOfInterview = dueDateOfInterview;
    }

    public void setDoneOne(Boolean doneOne) {
        this.doneOne = doneOne;
    }

    public void setDoneTwo(Boolean doneTwo) {
        this.doneTwo = doneTwo;
    }
}
