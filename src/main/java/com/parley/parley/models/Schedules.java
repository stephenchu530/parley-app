package com.parley.parley.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long studentOne;
    Long promptOne;
    Long studentTwo;
    Long promptTwo;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date dueDateOfInterview;

        //Default Constructor
        public Schedules() {}

        public Schedules(Long studentOne,
                         Long promptOne,
                         Long studentTwo,
                         Long promptTwo,
                         Date dueDateOfInterview) {
            this.setStudentOne(studentOne);
            this.setPromptOne(promptOne);
            this.setStudentTwo(studentTwo);
            this.setPromptTwo(promptTwo);
            this.setDueDateOfInterview(dueDateOfInterview);
        }
        // Getters
        public Long getId() {
            return id;
        }

        public Long getStudentOne() {
            return studentOne;
        }

        public Long getPromptOne() {
            return promptOne;
        }

        public Long getStudentTwo() {
            return studentTwo;
        }

        public Long getPromptTwo() {
            return promptTwo;
        }

        public Date getDueDateOfInterview() {
            return dueDateOfInterview;
        }

        // Setters

        public void setId(Long id) {
            this.id = id;
        }

        public void setStudentOne(Long studentOne) {
            this.studentOne = studentOne;
        }

        public void setPromptOne(Long promptOne) {
            this.promptOne = promptOne;
        }

        public void setStudentTwo(Long studentTwo) {
            this.studentTwo = studentTwo;
        }

        public void setPromptTwo(Long promptTwo) {
            this.promptTwo = promptTwo;
        }

        public void setDueDateOfInterview(Date dueDateOfInterview) {
            this.dueDateOfInterview = dueDateOfInterview;
        }
}
