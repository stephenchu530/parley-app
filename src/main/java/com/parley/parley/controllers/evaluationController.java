package com.parley.parley.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class evaluationController {

    @GetMapping("/evaluation")
    public String evaluation(){
        return "evaluation";
    }
}
