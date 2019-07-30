package com.parley.parley.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Assessments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date dateOfInterview;
    Long prompt;
    Long interviewer;
    Long interviewee;
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

    public Assessments(Date dateOfInterview,
                       Long prompt,
                       Long interviewer,
                       Long interviewee,
                       String whiteboardImgURL,
                       Integer interpretationScore,
                       String interpretationComments,
                       Integer solutionScore,
                       String solutionComments,
                       Integer analysisScore,
                       String analysisComments,
                       Integer communicationScore,
                       String communicationComments,
                       Integer overallScore,
                       String overallComments) {
        this.setDateOfInterview(dateOfInterview);
        this.setPrompt(prompt);
        this.setInterviewer(interviewer);
        this.setInterviewee(interviewee);
        this.setWhiteboardImgURL(whiteboardImgURL);
        this.setInterpretationScore(interpretationScore);
        this.setInterpretationComments(interpretationComments);
        this.setSolutionScore(solutionScore);
        this.setSolutionComments(solutionComments);
        this.setAnalysisScore(analysisScore);
        this.setAnalysisComments(analysisComments);
        this.setCommunicationScore(communicationScore);
        this.setCommunicationComments(communicationComments);
        this.setOverallScore(overallScore);
        this.setOverallComments(overallComments);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Date getDateOfInterview() {
        return dateOfInterview;
    }

    public Long getPrompt() {
        return prompt;
    }

    public Long getInterviewer() {
        return interviewer;
    }

    public Long getInterviewee() {
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
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateOfInterview(Date dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public void setPrompt(Long prompt) {
        this.prompt = prompt;
    }

    public void setInterviewer(Long interviewer) {
        this.interviewer = interviewer;
    }

    public void setInterviewee(Long interviewee) {
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
