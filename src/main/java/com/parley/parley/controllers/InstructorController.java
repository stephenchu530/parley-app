package com.parley.parley.controllers;

import com.parley.parley.repository.InstructorRepository;
import com.parley.parley.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;

@Controller
public class InstructorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private RoleRepository roleRepository;

    

}
