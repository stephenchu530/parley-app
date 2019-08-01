package com.parley.parley.controllers;

import com.parley.parley.models.RoleType;
import com.parley.parley.models.UserAccount;
import com.parley.parley.repository.SchedulesRepository;
import com.parley.parley.repository.UserAccountRepository;
import com.parley.parley.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;


@Controller
public class UserAccountController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    SchedulesRepository schedulesRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String splashPage(){
        return "login";
    }

    @GetMapping("/login")
    public String login(Principal principal){
        return "myprofile";
    }

    @PostMapping("/login")
    public String loginAfterRegister(){
        return "myprofile";
    }

    @GetMapping("/myprofile")
    public String profile(Principal principal, Model model) {
        UserAccount user = userAccountRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "myprofile";
    }

    @GetMapping("/myassessments")
    public String myassessments(Principal principal, Model model) {
        UserAccount user = userAccountRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "myassessments";
    }

    @PostMapping("/register")
    public RedirectView addNewStudent(String firstName, String lastName, String username, String password, String classDesignator, String email) {

        UserAccount user = new UserAccount(firstName, lastName, username, bCryptPasswordEncoder.encode(password), classDesignator, email);

        userAccountRepository.save(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/myprofile");
    }

    @GetMapping("/makeAdmin")
    public String makeAdminGet(Principal user, Model model){
        Iterable<UserAccount> users = userAccountRepository.findAll();
        model.addAttribute("user", userAccountRepository.findByUsername(user.getName()));
        model.addAttribute("users", users);
        return "makeAdmin";
    }

    @PostMapping("/makeAdmin")
    public RedirectView makeInstructor(Principal principal, Model model, String makeAdmin){
        if(userAccountRepository.findByUsername(principal.getName()).isAdmin()){
            UserAccount chosenOne = userAccountRepository.findByUsername(makeAdmin);
            RoleType adminRole = roleRepository.findByRole("admin");
            chosenOne.getRoleTypes().add(adminRole);
            userAccountRepository.save(chosenOne);
        }
        return new RedirectView("/myprofile");
    }

    @GetMapping("/logout_complete")
    public String logoutPage(){
        return "logout_completed";
    }

    @GetMapping("/aboutus")
    public String getAboutUs(Principal principal, Model model){
        UserAccount user = userAccountRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "aboutus";
    }

}
