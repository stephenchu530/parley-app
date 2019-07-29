package com.parley.parley.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Assessments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date dateOfInterview;
    UUID prompt;
    UUID interviewer;
    UUID interviewee;
    String whiteboardImgURL;
    Integer interpretationScore;
    String interpretationComments;
    Integer solutionScore;
    String solutionComments;
    Integer analysisScore;
    String analysisComments;
    Integer communicationScore;
    String communicationComments;
    Integer overallScore;
    String overallComments;

    // Default Constructor
    public Assessments() {}

    // Getters
    public UUID getId() {
        return id;
    }

    public Date getDateOfInterview() {
        return dateOfInterview;
    }

    public UUID getPrompt() {
        return prompt;
    }

    public UUID getInterviewer() {
        return interviewer;
    }

    public UUID getInterviewee() {
        return interviewee;
    }

    public String getWhiteboardImgURL() {
        return whiteboardImgURL;
    }

    public Integer getInterpretationScore() {
        return interpretationScore;
    }

    public String getInterpretationComments() {
        return interpretationComments;
    }

    public Integer getSolutionScore() {
        return solutionScore;
    }

    public String getSolutionComments() {
        return solutionComments;
    }

    public Integer getAnalysisScore() {
        return analysisScore;
    }

    public String getAnalysisComments() {
        return analysisComments;
    }

    public Integer getCommunicationScore() {
        return communicationScore;
    }

    public String getCommunicationComments() {
        return communicationComments;
    }

    public Integer getOverallScore() {
        return overallScore;
    }

    public String getOverallComments() {
        return overallComments;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setDateOfInterview(Date dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public void setPrompt(UUID prompt) {
        this.prompt = prompt;
    }

    public void setInterviewer(UUID interviewer) {
        this.interviewer = interviewer;
    }

    public void setInterviewee(UUID interviewee) {
        this.interviewee = interviewee;
    }

    public void setWhiteboardImgURL(String whiteboardImgURL) {
        this.whiteboardImgURL = whiteboardImgURL;
    }

    public void setInterpretationScore(Integer interpretationScore) {
        this.interpretationScore = interpretationScore;
    }

    public void setInterpretationComments(String interpretationComments) {
        this.interpretationComments = interpretationComments;
    }

    public void setSolutionScore(Integer solutionScore) {
        this.solutionScore = solutionScore;
    }

    public void setSolutionComments(String solutionComments) {
        this.solutionComments = solutionComments;
    }

    public void setAnalysisScore(Integer analysisScore) {
        this.analysisScore = analysisScore;
    }

    public void setAnalysisComments(String analysisComments) {
        this.analysisComments = analysisComments;
    }

    public void setCommunicationScore(Integer communicationScore) {
        this.communicationScore = communicationScore;
    }

    public void setCommunicationComments(String communicationComments) {
        this.communicationComments = communicationComments;
    }

    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }

    public void setOverallComments(String overallComments) {
        this.overallComments = overallComments;
    }
}
