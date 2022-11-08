//transfiere datos de la api al cliente

package com.backendportfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class ProjectsDto {
    
    @NotBlank
    private String img;
    @NotBlank
    private String title;
    @NotBlank
    private int date;
    @NotBlank
    private String description;
    @NotBlank
    private String prjLink;

    // contructores
    public ProjectsDto() {
    }

    public ProjectsDto(String img, String title, int date, String description, String prjLink) {
        this.img = img;
        this.title = title;
        this.date = date;
        this.description = description;
        this.prjLink = prjLink;
    }

    // getters y setters
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrjLink() {
        return prjLink;
    }

    public void setPrjLink(String prjLink) {
        this.prjLink = prjLink;
    }

}
