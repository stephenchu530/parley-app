package com.parley.parley.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@DynamoDBTable(tableName = "assessments")
public class Assessments {

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
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public UUID getId() {
        return id;
    }

    @DynamoDBAttribute
    public Date getDateOfInterview() {
        return dateOfInterview;
    }

    @DynamoDBAttribute
    public UUID getPrompt() {
        return prompt;
    }

    @DynamoDBAttribute
    public UUID getInterviewer() {
        return interviewer;
    }

    @DynamoDBAttribute
    public UUID getInterviewee() {
        return interviewee;
    }

    @DynamoDBAttribute
    public String getWhiteboardImgURL() {
        return whiteboardImgURL;
    }

    @DynamoDBAttribute
    public Integer getInterpretationScore() {
        return interpretationScore;
    }

    @DynamoDBAttribute
    public String getInterpretationComments() {
        return interpretationComments;
    }

    @DynamoDBAttribute
    public Integer getSolutionScore() {
        return solutionScore;
    }

    @DynamoDBAttribute
    public String getSolutionComments() {
        return solutionComments;
    }

    @DynamoDBAttribute
    public Integer getAnalysisScore() {
        return analysisScore;
    }

    @DynamoDBAttribute
    public String getAnalysisComments() {
        return analysisComments;
    }

    @DynamoDBAttribute
    public Integer getCommunicationScore() {
        return communicationScore;
    }

    @DynamoDBAttribute
    public String getCommunicationComments() {
        return communicationComments;
    }

    @DynamoDBAttribute
    public Integer getOverallScore() {
        return overallScore;
    }

    @DynamoDBAttribute
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
