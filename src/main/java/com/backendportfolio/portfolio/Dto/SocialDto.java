package com.backendportfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class SocialDto {
    
    @NotBlank
    private String socialName;
    @NotBlank
    private String socialLink;

    //constructores
    public SocialDto() {
    }

    public SocialDto(String socialName, String socialLink) {
        this.socialName = socialName;
        this.socialLink = socialLink;
    }

    //getters y setters
    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getSocialLink() {
        return socialLink;
    }

    public void getSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }

}
