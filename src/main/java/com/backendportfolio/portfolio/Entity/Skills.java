package com.backendportfolio.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String skillName;

    private String skillType;
    
    //constructores
    public Skills() {
    }

    public Skills(String skillName, String skillType) {
        this.skillName = skillName;
        this.skillType = skillType;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

}
