package com.parley.parley.controllers;

import com.parley.parley.config.S3Client;
import com.parley.parley.models.Prompts;
import com.parley.parley.repository.PromptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class PromptsController {

    private S3Client s3Client;

    @Autowired
    PromptsController(S3Client s3Client){
        this.s3Client = s3Client;
    }

    @Autowired
    PromptsRepository promptsRepository;

    @GetMapping("/prompt")
    public String showPromptEntryPage(){
        return "add_prompt";
    }

    @PostMapping("/prompt")
    public RedirectView addNewPrompt(String title, String category, MultipartFile file){
        String fileUrl = s3Client.uploadFile2Prompts(file);
        Prompts prompt = new Prompts(title, category, fileUrl);
        promptsRepository.save(prompt);
        return new RedirectView("/instructors");
    }


}
