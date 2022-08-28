//transfiere datos de la api al cliente

package com.backendportfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class EducationDto {
    
    @NotBlank
    private String title;
    @NotBlank
    private String academyName;
    @NotBlank
    private String certificationLink;

    //constructores
    public EducationDto() {
    }

    public EducationDto(String title, String academyName, String certificationLink) {
        this.title = title;
        this.academyName = academyName;
        this.certificationLink = certificationLink;
    }
    
    // getters y setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getCertificationLink() {
        return certificationLink;
    }

    public void setCertificationLink(String certificationLink) {
        this.certificationLink = certificationLink;
    }
    
}
