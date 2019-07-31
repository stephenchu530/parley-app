package com.parley.parley.controllers;

import com.parley.parley.models.Prompts;
import com.parley.parley.models.Schedules;
import com.parley.parley.models.UserAccount;
import com.parley.parley.repository.PromptsRepository;
import com.parley.parley.repository.RoleRepository;
import com.parley.parley.repository.SchedulesRepository;
import com.parley.parley.repository.UserAccountRepository;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class scheduleInterviewController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    SchedulesRepository schedulesRepository;

    @Autowired
    PromptsRepository promptsRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/schedule")
    public String scheduleInterview(Principal principal, Model model) {
        UserAccount user = userAccountRepository.findByUsername(principal.getName());
        Iterable<UserAccount> tmpList = userAccountRepository.findAll();
        Iterable<Prompts> promptsList = promptsRepository.findAll();

        List<UserAccount> studentList = new ArrayList<>();
        for (UserAccount student: tmpList) {
            if (student.isAdmin() == false) {
                studentList.add(student);
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("studentlist", studentList);
        model.addAttribute("promptslist", promptsList);
        return "addSchedule";
    }

    @PostMapping("/scheduleinterview")
    public RedirectView scheduleTheInterview(@RequestParam Long studentOneId,
                                             @RequestParam Long promptOneId,
                                             @RequestParam Long studentTwoId,
                                             @RequestParam Long promptTwoId,
                                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dueDate,
                                             Principal principal) {
        UserAccount studentOne = userAccountRepository.findById(studentOneId).get();
        UserAccount studentTwo = userAccountRepository.findById(studentTwoId).get();
        Schedules newScheduledInterview = new Schedules(studentOne, promptOneId, studentTwo, promptTwoId, dueDate);
        schedulesRepository.save(newScheduledInterview);

        List<Schedules> scheduledInterviewsOne = studentOne.getInterviewSchedule();
        scheduledInterviewsOne.add(newScheduledInterview);
        studentOne.setInterviewSchedule(scheduledInterviewsOne);
        userAccountRepository.save(studentOne);

        List<Schedules> scheduledInterviewsTwo = studentTwo.getInterviewSchedule();
        scheduledInterviewsTwo.add(newScheduledInterview);
        studentTwo.setInterviewSchedule(scheduledInterviewsTwo);
        userAccountRepository.save(studentTwo);

        // BACKUP IN CASE SHIT GOES SOUTH
//        Schedules newScheduledInterview = new Schedules(studentOneId, promptOneId, studentTwoId, promptTwoId, dueDate);
//        schedulesRepository.save(newScheduledInterview);
//
//        UserAccount studentOne = userAccountRepository.findById(studentOneId).get();
//        List<Long> studentOneNewSchedule = studentOne.getInterviewSchedule();
//        studentOneNewSchedule.add(newScheduledInterview.getId());
//        studentOne.setInterviewSchedule(studentOneNewSchedule);
//        userAccountRepository.save(studentOne);
//
//        UserAccount studentTwo = userAccountRepository.findById(studentTwoId).get();
//        List<Long> studentTwoNewSchedule = studentTwo.getInterviewSchedule();
//        studentTwoNewSchedule.add(newScheduledInterview.getId());
//        studentTwo.setInterviewSchedule(studentTwoNewSchedule);
//        userAccountRepository.save(studentTwo);

        return new RedirectView("/myprofile");
    }
}
