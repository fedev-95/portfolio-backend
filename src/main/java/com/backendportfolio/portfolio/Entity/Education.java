//conecta con la base de datos

package com.backendportfolio.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String title;
    private String academyName;
    private String certificationLink;

    
    //constructores
    public Education() {
    }

    public Education(String title, String academyName, String certificationLink) {
        this.title = title;
        this.academyName = academyName;
        this.certificationLink = certificationLink;
    }
    
    
    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
