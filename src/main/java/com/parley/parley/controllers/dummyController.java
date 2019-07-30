//package com.parley.parley.controllers;
//
//import com.parley.parley.models.Assessments;
//import com.parley.parley.repository.PromptsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//
//public class dummyController {
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    PromptsRepository promptRepository;
//
//
//    public void saveToTxt(Assessments assessment) throws FileNotFoundException {
//        //get interviewee and interviewer names from ID
//        Student giving = studentRepository.findById(assessment.getInterviewer()).get();
//        Student receiving = studentRepository.findById(assessment.getInterviewee()).get();
//        String assessmentDate = assessment.getDateOfInterview().toString();
//        File otherFile = new File(assessmentDate+receiving.getUsername()+".txt"); //figure this out - send straight to s3 bucket instead of filename
//        PrintWriter toFile = new PrintWriter(otherFile);
//        StringBuilder results = new StringBuilder();
//        // get date from assess obj
//        results.append(String.format("%s\n", assessmentDate));
//        results.append("\n");
//        results.append(String.format("Interviewee: %s\n  by: %s\n", receiving, giving));
//        results.append("\n");
//        //get prompt title
//        results.append(String.format("Prompt: %s\n", promptRepository.findById(assessment.getPrompt())));
//        results.append("\n");
//        // get scores from assess obj
//        results.append(String.format("Interpreted the Question: %d/10\nSolved the Technical Problem: %d/12\nAnalyzed the Proposed Solution: %d/6\nCommunicated Effectively: %d/12\nTotal Score: %d/40\n",
//                assessment.getInterpretationScore(),
//                assessment.getSolutionScore(),
//                assessment.getAnalysisScore(),
//                assessment.getCommunicationScore(),
//                assessment.getOverallScore())
//        );
//        results.append("\n");
//        //get comments from assess obj
//        String interpComm = assessment.getInterpretationComments();
//        String solutionComm = assessment.getSolutionComments();
//        String analysComm = assessment.getAnalysisComments();
//        String commComm = assessment.getCommunicationComments();
//        String overallComm = assessment.getOverallComments();
//        //
//        results.append("Comments: \n");
//        results.append(String.format(interpComm + "\n"));
//        results.append("\n");
//        results.append(String.format(solutionComm + "\n"));
//        results.append("\n");
//        results.append(String.format(analysComm + "\n"));
//        results.append("\n");
//        results.append(String.format(commComm + "\n"));
//        results.append("\n");
//        results.append(String.format(overallComm + "\n"));
//        toFile.println(results);
//        toFile.close();
//        //send file to s3 bucket.
////        otherFile.delete();
//    }
//}
