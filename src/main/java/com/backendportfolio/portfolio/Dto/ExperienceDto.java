//transfiere datos de la api al cliente

package com.backendportfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class ExperienceDto {
    
    @NotBlank
    private String rol;
    @NotBlank
    private int startYear;
    @NotBlank
    private int endYear;
    @NotBlank
    private String company;
    @NotBlank
    private String description;

    // constructores
    public ExperienceDto() {
    }

    public ExperienceDto(String rol, int startYear, int endYear, String company, String description) {
        this.rol = rol;
        this.startYear = startYear;
        this.endYear = endYear;
        this.company = company;
        this.description = description;
    }
    
    //getters y setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    
    
}
