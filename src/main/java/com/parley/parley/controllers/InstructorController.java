package com.parley.parley.controllers;

import com.parley.parley.models.Instructor;
import com.parley.parley.models.Student;
import com.parley.parley.repository.InstructorRepository;
import com.parley.parley.repository.RoleRepository;
import com.parley.parley.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;


@Controller
public class InstructorController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String splashPage(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "myprofile";
    }

    @PostMapping("/login")
    public String loginAfterRegister(){
        return "myprofile";
    }

    @PostMapping("/register/student")
    public RedirectView addNewStudent(String firstname, String lastname, String username, String password, String classDesignator, String email) {
        System.out.println("this ran first");
        Student newStudent = new Student(firstname, lastname, username, bCryptPasswordEncoder.encode(password), classDesignator, email);
        System.out.println("this ran");
        studentRepository.save(newStudent);
        System.out.println("this ran next");
        Authentication authentication = new UsernamePasswordAuthenticationToken(newStudent, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("authentication works, next is reidrect");
        return new RedirectView("/login");
    }

    @PostMapping("/register/instructor")
    public RedirectView addNewInstructor(String firstname, String lastname, String username, String password, String email) {
        Instructor instructor = new Instructor(firstname, lastname, username, bCryptPasswordEncoder.encode(password), email);
        instructorRepository.save(instructor);
        Authentication authentication = new UsernamePasswordAuthenticationToken(instructor, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }


}
