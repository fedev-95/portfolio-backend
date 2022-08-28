package com.backendportfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class ProfileDto {
    
    @NotBlank
    private String img;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String title;
    @NotBlank
    private String description;

    // contructores
    public ProfileDto() {
    }

    public ProfileDto(String img, String name, String lastname, String title, String description) {
        this.img = img;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
