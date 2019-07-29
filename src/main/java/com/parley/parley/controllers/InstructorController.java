package com.parley.parley.controllers;

import com.parley.parley.repository.InstructorRepository;
import com.parley.parley.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class InstructorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public String splashPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(){
        return "myprofile2";
    }


//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String createUser(@Valid @ModelAttribute UserAccount user, BindingResult binding, RedirectAttributes redirect) {
//        if(binding.hasErrors() || !user.getConfirmPassword().equals(user.getPassword())) {
//            List<String> customErrors = new ArrayList<>();
//            binding.getAllErrors().forEach(error -> customErrors.add(error.getDefaultMessage()));
//            if(!user.getConfirmPassword().equals(user.getPassword())) {
//                customErrors.add("Password must match.");
//            }
//            redirect.addFlashAttribute("errors", customErrors);
//            return "redirect:/login#registration";
//        }
//
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.getRoleTypes().add(roleRepository.findByRole("user"));
//        userRepository.save(user);
//
//        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        EmailSender.sendEmail(user, null, "INTRO", null);
//        return "redirect:/main";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String indexError(@RequestParam(value = "error", required=false) boolean error, RedirectAttributes redirect) {
//        if(error) {
//            redirect.addFlashAttribute("error", "Incorrect Credentials");
//            return "redirect:/login#registration";
//        }
//        return "login";
//    }


}
