package com.parley.parley.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    UUID studentOne;
    UUID promptOne;
    UUID studentTwo;
    UUID promptTwo;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date dueDateOfInterview;

        //Default Constructor
        public Schedules() {}

        public Schedules(UUID studentOne,
                         UUID promptOne,
                         UUID studentTwo,
                         UUID promptTwo,
                         Date dueDateOfInterview) {
            this.setStudentOne(studentOne);
            this.setPromptOne(promptOne);
            this.setStudentTwo(studentTwo);
            this.setPromptTwo(promptTwo);
            this.setDueDateOfInterview(dueDateOfInterview);
        }
        // Getters
        public UUID getId() {
            return id;
        }

        public UUID getStudentOne() {
            return studentOne;
        }

        public UUID getPromptOne() {
            return promptOne;
        }

        public UUID getStudentTwo() {
            return studentTwo;
        }

        public UUID getPromptTwo() {
            return promptTwo;
        }

        public Date getDueDateOfInterview() {
            return dueDateOfInterview;
        }

        // Setters

        public void setId(UUID id) {
            this.id = id;
        }

        public void setStudentOne(UUID studentOne) {
            this.studentOne = studentOne;
        }

        public void setPromptOne(UUID promptOne) {
            this.promptOne = promptOne;
        }

        public void setStudentTwo(UUID studentTwo) {
            this.studentTwo = studentTwo;
        }

        public void setPromptTwo(UUID promptTwo) {
            this.promptTwo = promptTwo;
        }

        public void setDueDateOfInterview(Date dueDateOfInterview) {
            this.dueDateOfInterview = dueDateOfInterview;
        }
}
