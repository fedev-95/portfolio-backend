package com.backendportfolio.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Social {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String socialName;

    private String socialLink;

    //constructores
    public Social() {
    }

    public Social(String socialName, String socialLink) {
        this.socialName = socialName;
        this.socialLink = socialLink;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getSocialLink() {
        return socialLink;
    }

    public void setSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }

}
