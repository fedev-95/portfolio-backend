package com.backendportfolio.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class SkillsDto {
    
    @NotBlank
    private String skillName;
    @NotBlank
    private String skillType;
    
    //constructores
    public SkillsDto() {
    }

    public SkillsDto(String skillName, String skillType) {
        this.skillName = skillName;
        this.skillType = skillType;
    }

    //getters y setters
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void getSkillType(String skillType) {
        this.skillType = skillType;
    }

}
