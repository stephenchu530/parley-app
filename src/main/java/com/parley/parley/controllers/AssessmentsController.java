package com.parley.parley.controllers;

import com.parley.parley.models.Assessments;
import com.parley.parley.models.Schedules;
import com.parley.parley.repository.AssessmentsRepository;
import com.parley.parley.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AssessmentsController {

    @Autowired
    SchedulesRepository schedulesRepository;
    @Autowired
    AssessmentsRepository assessmentsRepository;

    @PostMapping("/assessments/{id}")
    public RedirectView compileAssessment(@PathVariable long id,
                                          String range0,
                                          String range1,
                                          String range2,
                                          String range3,
                                          String range4,
                                          String range5,
                                          String range6,
                                          String range7,
                                          String range8,
                                          String range9,
                                          String range10,
                                          String range11,
                                          String range12,
                                          String range13,
                                          String range14,
                                          String range15,
                                          String range16,
                                          String interpretationComments,
                                          String solutionComments,
                                          String analysisComments,
                                          String communicationComments,
                                          String overallScore
                                          ){
        Schedules current = schedulesRepository.findById(id).get();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String today = simpleDateFormat.format(new Date());
        Assessments thisAssessment = new Assessments(
                today,
                current.getPromptOne(),
                current.getStudentOne(),
                current.getStudentTwo(),
                {interpretation score},
                {interpretationComments},
                {solution score},
                {solutionComments},
                {analysis score},
                {analysisComments},
                {communications score},
                {communicationComments},
                Long.parseLong(overallScore)

        );
        return new RedirectView("/toFile/{assId}");
    }
}
