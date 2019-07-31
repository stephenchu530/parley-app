package com.parley.parley.controllers;

import com.parley.parley.models.Schedules;
import com.parley.parley.models.UserAccount;
import com.parley.parley.repository.SchedulesRepository;
import com.parley.parley.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class evaluationController {

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    SchedulesRepository schedulesRepository;

    @GetMapping("/evaluation/{interviewId}")
    public String evaluation(Model m, Principal p, @PathVariable long interviewId){
        Schedules thisInterview =  schedulesRepository.findById(interviewId).get();
        UserAccount loggedIn = userAccountRepository.findByUsername(p.getName());
        m.addAttribute("interviewID", thisInterview.getId());
        m.addAttribute("user", loggedIn);
        return "evaluation";
    }
}
