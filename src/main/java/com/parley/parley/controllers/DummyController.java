package com.parley.parley.controllers;

import com.parley.parley.config.S3Client;
import com.parley.parley.models.Assessments;
//import com.parley.parley.models.Schedules;
import com.parley.parley.models.UserAccount;
import com.parley.parley.repository.AssessmentsRepository;
import com.parley.parley.repository.PromptsRepository;
//import com.parley.parley.repository.SchedulesRepository;
import com.parley.parley.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class DummyController {

    private S3Client s3Client;

    @Autowired
    DummyController(S3Client s3Client){
        this.s3Client = s3Client;
    }
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    PromptsRepository promptRepository;
    @Autowired
    AssessmentsRepository assessmentsRepository;
//    @Autowired
//    SchedulesRepository schedulesRepository;

    @GetMapping("/toFile/{id}")
    public RedirectView saveToTxt(@PathVariable String id) throws FileNotFoundException {
        Assessments assessment = assessmentsRepository.findById(Long.valueOf(id)).get();
        UserAccount giving = userAccountRepository.findById(assessment.getInterviewer()).get();
        UserAccount receiving = userAccountRepository.findById(assessment.getInterviewee()).get();
        String assessmentDate = assessment.getDateOfInterview().toString().substring(0,10);
        File otherFile = new File(assessmentDate+receiving.getUsername()+".txt");
        PrintWriter toFile = new PrintWriter(otherFile);
        StringBuilder results = new StringBuilder();
        results.append(String.format("%s\n", assessmentDate.substring(0,10)));
        results.append("\n");
        results.append("__________________________________\n");
        results.append(String.format("Interviewee: %s\n  by: %s\n", receiving.getFirstName(), giving.getFirstName()));
        results.append("__________________________________");
        results.append("\n");
        String prompt = promptRepository.findById(assessment.getPrompt()).get().getTitle();
        results.append(String.format("Prompt: %s\n", prompt));
        results.append("__________________________________\n");
        results.append("__________________________________\n");
        results.append("\n");
        String body = String.format(
                "Interpreted the question:\n" +
                        "----------------------------------\n" +
                        "Asked meaningful clarifying questions:           %d/2 points.\n" +
                        "Identified inputs and outputs:                   %d/2 points.\n" +
                        "Visually illustrated the problem domain:         %d/2 points.\n" +
                        "Identified optimal data structure and algorithm: %d/4 points.\n" +
                        "Comments: \n%s\n" +
                        "----------------------------------\n" +
                        "Solved the Technical Problem:\n" +
                        "\n" +
                        "Presented and understood a working algorithm: %d/4 points.\n" +
                        "Final code was syntactically correct:         %d/3 points.\n" +
                        "Final code was idiomatically correct:         %d/3 points.\n" +
                        "Solution was the best possible option:        %d/2 points.\n" +
                        "Comments: \n%s\n" +
                        "----------------------------------\n" +
                        "Analyzed the Proposed Solution:\n" +
                        "\n" +
                        "Stepped through their solution:    %d/2 points.\n" +
                        "Big O time and space are analyzed: %d/2 points.\n" +
                        "Explain an approach to testing:    %d/2 points.\n" +
                        "Comments: \n%s\n" +
                        "----------------------------------\n" +
                        "Communicated Effectively Throughout:\n" +
                        "\n" +
                        "Verbalized their thought process:                     %d/6 points.\n" +
                        "Used correct terminology:                             %d/2 points.\n" +
                        "Used the time available effectively:                  %d/1 point.\n" +
                        "Was not overconfident (not listening to suggestions): %d/1 point. \n" +
                        "Was not under-confident (unsure of known algorithm):  %d/1 point.\n" +
                        "Whiteboard was readable (penmanship and spacing):     %d/1 point.\n" +
                        "Comments: \n%s\n" +
                        "\n" +
                        "Final score: %d out of 40 points.\n",
                assessment.getMeaningfulQuestionsScore(), assessment.getIdentifyIOScore(), assessment.getVisualizeProblemScore(),
                assessment.getOptimalDSAScore(), assessment.getInterpretationComments(), assessment.getWorkingAlgoScore(), assessment.getSyntacticallyCorrectScore(),
                assessment.getIdiomaticallyCorrectScore(), assessment.getBestSolutionScore(), assessment.getSolutionComments(), assessment.getStepThroughSolutionScore(),
                assessment.getTimeSpaceAnalysisScore(), assessment.getTestingApproachScore(), assessment.getAnalysisComments(), assessment.getVerbalizedThoughtsScore(),
                assessment.getCorrectTerminologyScore(), assessment.getUseTimeEfficientlyScore(), assessment.getNotOverconfidentScore(), assessment.getNotUnderConfidentScore(),
                assessment.getWhiteboardLegibleScore(), assessment.getCommunicationComments(), assessment.getOverallScore()
        );
        results.append(body);
        toFile.println(results);
        toFile.close();
        String fileUrl = s3Client.uploadFile2Pdfs(otherFile);
        UserAccount student = userAccountRepository.findById(assessment.getInterviewee()).get();
        List tempList = student.getListOfAssessments();
        tempList.add(fileUrl);
        student.setListOfAssessments(tempList);
        userAccountRepository.save(student);
        otherFile.delete();
        return new RedirectView("/myprofile");
    }
}
