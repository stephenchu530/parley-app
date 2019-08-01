package com.parley.parley.controllers;

import com.parley.parley.models.Prompts;
import com.parley.parley.models.Schedules;
import com.parley.parley.models.UserAccount;
import com.parley.parley.repository.PromptsRepository;
import com.parley.parley.repository.SchedulesRepository;
import com.parley.parley.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;

@Controller
public class evaluationController {

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    SchedulesRepository schedulesRepository;
    @Autowired
    PromptsRepository promptsRepository;

    @GetMapping("/evaluation/{interviewId}")
    public String evaluation(Model m, Principal p, @PathVariable long interviewId){
        Schedules thisInterview =  schedulesRepository.findById(interviewId).get();
        UserAccount loggedIn = userAccountRepository.findByUsername(p.getName());
        String promptUrl = "";
        if (!thisInterview.getDoneOne()) {
            promptUrl = promptsRepository.findById(thisInterview.getPromptOne()).get().getPromptUrl();
        } else {
            promptUrl = promptsRepository.findById(thisInterview.getPromptTwo()).get().getPromptUrl();
        }
        m.addAttribute("promptUrl", promptUrl);
        m.addAttribute("interviewID", interviewId);
        m.addAttribute("user", loggedIn);
        return "evaluation";
    }
}
