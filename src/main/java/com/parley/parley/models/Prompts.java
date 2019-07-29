package com.parley.parley.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Prompts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String title;
    private String category;
    private String promptUrl;

    //Default Constructor
    public Prompts() {}

    public Prompts(String title,
                   String category,
                   String promptUrl) {
        this.setTitle(title);
        this.setCategory(category);
        this.setPromptUrl(promptUrl);
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPromptUrl() {
        return this.promptUrl;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPromptUrl(String promptUrl) {
        this.promptUrl = promptUrl;
    }
}
