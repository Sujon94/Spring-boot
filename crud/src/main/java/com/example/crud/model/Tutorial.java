package com.example.crud.model;

import javax.persistence.*;
//@Entity annotation indicates that the class is a persistent Java class
@Entity
//@Table annotation provides the table that maps this entity.
@Table(name="tutorials")
public class Tutorial {
    //@Id annotation is for the primary key.
    @Id
    //@GeneratedValue annotation is used to DEFINE GENERATION STRATEGY for the primary key.
    // GenerationType.AUTO means Auto Increment field.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@Column annotation is used to DEFINE the COLUMN in database that maps annotated field.
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    public Tutorial(){

    }

    public Tutorial(String title, String description, boolean published){
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean isPublished(){
        return published;
    }

    public void setPublished(boolean isPublished){
        this.published = isPublished;
    }

    public String toString(){
        return "Tutorial [id="+id+", title="+title+",desc="+description+",published="+published+"]";
    }
}
