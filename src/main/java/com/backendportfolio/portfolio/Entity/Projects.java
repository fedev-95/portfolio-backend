//conecta con la base de datos

package com.backendportfolio.portfolio.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "LONGTEXT")
    private String img;
    private String title;
    private int date;
    private String description;
    private String prjLink;

    // contructores
    public Projects() {
    }

    public Projects(String img, String title, int date, String description, String prjLink) {
        this.img = img;
        this.title = title;
        this.date = date;
        this.description = description;
        this.prjLink = prjLink;

    }

    // getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
