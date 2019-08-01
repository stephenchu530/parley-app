package com.parley.parley.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Assessments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date dateOfInterview;
    Long prompt;
    Long interviewer;
    Long interviewee;
    Integer meaningfulQuestionsScore;
    Integer identifyIOScore;
    Integer visualizeProblemScore;
    Integer optimalDSAScore;
    String whiteboardImgURL;
    String interpretationComments;
    Integer workingAlgoScore;
    Integer syntacticallyCorrectScore;
    Integer idiomaticallyCorrectScore;
    Integer bestSolutionScore;
    String solutionComments;
    Integer stepThroughSolutionScore;
    Integer timeSpaceAnalysisScore;
    Integer testingApproachScore;
    String analysisComments;
    Integer verbalizedThoughtsScore;
    Integer correctTerminologyScore;
    Integer useTimeEfficientlyScore;
    Integer notOverconfidentScore;
    Integer notUnderConfidentScore;
    Integer whiteboardLegibleScore;
    String communicationComments;
    Integer overallScore;

    // Default Constructor
    public Assessments() {}

    public Assessments(Date dateOfInterview,
                       Long prompt,
                       Long interviewer,
                       Long interviewee,
                       Integer meaningfulQuestionsScore,
                       Integer identifyIOScore,
                       Integer visualizeProblemScore,
                       Integer optimalDSAScore,
                       String interpretationComments,
                       Integer workingAlgoScore,
                       Integer syntacticallyCorrectScore,
                       Integer idiomaticallyCorrectScore,
                       Integer bestSolutionScore,
                       String solutionComments,
                       Integer stepThroughSolutionScore,
                       Integer timeSpaceAnalysisScore,
                       Integer testingApproachScore,
                       String analysisComments,
                       Integer verbalizedThoughtsScore,
                       Integer correctTerminologyScore,
                       Integer useTimeEfficientlyScore,
                       Integer notOverconfidentScore,
                       Integer notUnderConfidentScore,
                       Integer whiteboardLegibleScore,
                       String communicationComments,
                       Integer overallScore
    ){
        this.dateOfInterview = dateOfInterview;
        this.prompt = prompt;
        this.interviewer = interviewer;
        this.interviewee = interviewee;
        this.meaningfulQuestionsScore = meaningfulQuestionsScore;
        this.identifyIOScore = identifyIOScore;
        this.visualizeProblemScore = visualizeProblemScore;
        this.optimalDSAScore = optimalDSAScore;
        this.interpretationComments = interpretationComments;
        this.workingAlgoScore = workingAlgoScore;
        this.syntacticallyCorrectScore = syntacticallyCorrectScore;
        this.idiomaticallyCorrectScore = idiomaticallyCorrectScore;
        this.bestSolutionScore = bestSolutionScore;
        this.solutionComments = solutionComments;
        this.stepThroughSolutionScore = stepThroughSolutionScore;
        this.timeSpaceAnalysisScore = timeSpaceAnalysisScore;
        this.testingApproachScore = testingApproachScore;
        this.analysisComments = analysisComments;
        this.verbalizedThoughtsScore = verbalizedThoughtsScore;
        this.correctTerminologyScore = correctTerminologyScore;
        this.useTimeEfficientlyScore = useTimeEfficientlyScore;
        this.notOverconfidentScore = notOverconfidentScore;
        this.notUnderConfidentScore = notUnderConfidentScore;
        this.whiteboardLegibleScore = whiteboardLegibleScore;
        this.communicationComments = communicationComments;
        this.overallScore = overallScore;
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
    public String getInterpretationComments() {
        return interpretationComments;
    }
    public String getSolutionComments() {
        return solutionComments;
    }
    public String getAnalysisComments() {
        return analysisComments;
    }
    public String getCommunicationComments() {
        return communicationComments;
    }
    public Integer getOverallScore() {
        return overallScore;
    }
    public Integer getMeaningfulQuestionsScore() {
        return meaningfulQuestionsScore;
    }
    public Integer getWhiteboardLegibleScore() {
        return whiteboardLegibleScore;
    }
    public Integer getNotUnderConfidentScore() {
        return notUnderConfidentScore;
    }
    public Integer getNotOverconfidentScore() {
        return notOverconfidentScore;
    }
    public Integer getUseTimeEfficientlyScore() {
        return useTimeEfficientlyScore;
    }
    public Integer getCorrectTerminologyScore() {
        return correctTerminologyScore;
    }
    public Integer getVerbalizedThoughtsScore() {
        return verbalizedThoughtsScore;
    }
    public Integer getTestingApproachScore() {
        return testingApproachScore;
    }
    public Integer getTimeSpaceAnalysisScore() {
        return timeSpaceAnalysisScore;
    }
    public Integer getStepThroughSolutionScore() {
        return stepThroughSolutionScore;
    }
    public Integer getBestSolutionScore() {
        return bestSolutionScore;
    }
    public Integer getIdiomaticallyCorrectScore() {
        return idiomaticallyCorrectScore;
    }
    public Integer getSyntacticallyCorrectScore() {
        return syntacticallyCorrectScore;
    }
    public Integer getWorkingAlgoScore() {
        return workingAlgoScore;
    }
    public Integer getOptimalDSAScore() {
        return optimalDSAScore;
    }
    public Integer getVisualizeProblemScore() {
        return visualizeProblemScore;
    }
    public Integer getIdentifyIOScore() {
        return identifyIOScore;
    }

    // Setters
    public void setId(Long id) { this.id = id;}
    public void setDateOfInterview(Date dateOfInterview) { this.dateOfInterview = dateOfInterview;}
    public void setPrompt(Long prompt) { this.prompt = prompt;}
    public void setInterviewer(Long interviewer) {this.interviewer = interviewer;}
    public void setInterviewee(Long interviewee) {
        this.interviewee = interviewee;
    }
    public void setWhiteboardImgURL(String whiteboardImgURL) {
        this.whiteboardImgURL = whiteboardImgURL;
    }
    public void setInterpretationComments(String interpretationComments) {this.interpretationComments = interpretationComments;}
    public void setSolutionComments(String solutionComments) {
        this.solutionComments = solutionComments;
    }
    public void setAnalysisComments(String analysisComments) {
        this.analysisComments = analysisComments;
    }
    public void setCommunicationComments(String communicationComments) { this.communicationComments = communicationComments;}
    public void setOverallScore(Integer overallScore) { this.overallScore = overallScore;}

    public void setMeaninfulQuestionsScore(Integer meaningfulQuestionsScore) {
        this.meaningfulQuestionsScore = meaningfulQuestionsScore;
    }
    public void setIdentifyIOScore(Integer identifyIOScore) {
        this.identifyIOScore = identifyIOScore;
    }
    public void setVisualizeProblemScore(Integer visualizeProblemScore) {
        this.visualizeProblemScore = visualizeProblemScore;
    }
    public void setOptimalDSAScore(Integer optimalDSAScore) {
        this.optimalDSAScore = optimalDSAScore;
    }
    public void setWorkingAlgoScore(Integer workingAlgoScore) {
        this.workingAlgoScore = workingAlgoScore;
    }
    public void setSyntacticallyCorrectScore(Integer syntacticallyCorrectScore) {
        this.syntacticallyCorrectScore = syntacticallyCorrectScore;
    }
    public void setIdiomaticallyCorrectScore(Integer idiomaticallyCorrectScore) {
        this.idiomaticallyCorrectScore = idiomaticallyCorrectScore;
    }
    public void setBestSolutionScore(Integer bestSolutionScore) {
        this.bestSolutionScore = bestSolutionScore;
    }
    public void setStepThroughSolutionScore(Integer stepThroughSolutionScore) {
        this.stepThroughSolutionScore = stepThroughSolutionScore;
    }
    public void setTimeSpaceAnalysisScore(Integer timeSpaceAnalysisScore) {
        this.timeSpaceAnalysisScore = timeSpaceAnalysisScore;
    }
    public void setTestingApproachScore(Integer testingApproachScore) {
        this.testingApproachScore = testingApproachScore;
    }
    public void setVerbalizedThoughtsScore(Integer verbalizedThoughtsScore) {
        this.verbalizedThoughtsScore = verbalizedThoughtsScore;
    }
    public void setCorrectTerminologyScore(Integer correctTerminologyScore) {
        this.correctTerminologyScore = correctTerminologyScore;
    }
    public void setUseTimeEfficientlyScore(Integer useTimeEfficientlyScore) {
        this.useTimeEfficientlyScore = useTimeEfficientlyScore;
    }
    public void setNotOverconfidentScore(Integer notOverconfidentScore) {
        this.notOverconfidentScore = notOverconfidentScore;
    }
    public void setNotUnderConfidentScore(Integer notUnderConfidentScore) {
        this.notUnderConfidentScore = notUnderConfidentScore;
    }
    public void setWhiteboardLegibleScore(Integer whiteboardLegibleScore) {
        this.whiteboardLegibleScore = whiteboardLegibleScore;
    }
}
