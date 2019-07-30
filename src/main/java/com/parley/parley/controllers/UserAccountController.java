package com.parley.parley.controllers;

import com.parley.parley.models.UserAccount;
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
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String profile(Principal principal, Model model){
        UserAccount user = userAccountRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "myprofile";
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
        model.addAttribute("loggedInUser", userAccountRepository.findByUsername(user.getName()));
        model.addAttribute("users", users);
        return "makeAdmin";
    }

//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public String user(Principal user, Model m) {
//        Iterable<UserAccount> userList = userRepository.findAll();
//        m.addAttribute("principal", userRepository.findByUsername(user.getName()));
//        m.addAttribute("users", userList);
//        return "user";
//    }

//    @PostMapping("/register")
//    public RedirectView addNewInstructor(String firstname, String lastname, String username, String password, String email) {
//        System.out.println("hits registration route");
//        UserAccount userAccount = new UserAccount(firstname, lastname, username, bCryptPasswordEncoder.encode(password), email);
//        userAccountRepository.save(userAccount);
//        Authentication authentication = new UsernamePasswordAuthenticationToken(userAccount, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        System.out.println("about to redirect");
//        return new RedirectView("/login");
//    }


}
