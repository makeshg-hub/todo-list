package com.todo.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoDTO {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    // Constructors
    public TodoDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public TodoDTO() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
