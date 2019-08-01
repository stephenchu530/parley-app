package com.parley.parley.controllers;

import com.parley.parley.models.Assessments;
import com.parley.parley.models.Schedules;
import com.parley.parley.repository.AssessmentsRepository;
import com.parley.parley.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AssessmentsController {

    @Autowired
    SchedulesRepository schedulesRepository;
    @Autowired
    AssessmentsRepository assessmentsRepository;

    @PostMapping("/assessments/{idString}")
    public RedirectView compileAssessment(@PathVariable String idString,
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
        long id = Long.parseLong(idString);
        Schedules current = schedulesRepository.findById(id).get();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String today = simpleDateFormat.format(new Date());
        Assessments thisAssessment = new Assessments(
                new Date(),
                current.getPromptOne(),
                current.getStudentOne().getId(),
                current.getStudentTwo().getId(),
                Integer.valueOf(range0),
                Integer.valueOf(range1),
                Integer.valueOf(range2),
                Integer.valueOf(range3),
                solutionComments,
                Integer.valueOf(range4),
                Integer.valueOf(range5),
                Integer.valueOf(range6),
                Integer.valueOf(range7),
                interpretationComments,
                Integer.valueOf(range8),
                Integer.valueOf(range9),
                Integer.valueOf(range10),
                analysisComments,
                Integer.valueOf(range11),
                Integer.valueOf(range12),
                Integer.valueOf(range13),
                Integer.valueOf(range14),
                Integer.valueOf(range15),
                Integer.valueOf(range16),
                communicationComments,
                Integer.valueOf(overallScore)
        );
        assessmentsRepository.save(thisAssessment);
        String assId = Long.toString(thisAssessment.getId());
        return new RedirectView("/toFile/" + assId);
    }
}
