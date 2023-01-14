package com.example.prmgs.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "project_members")
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Column(name = "project_id")
    private Long project_id;

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne(targetEntity = Project.class,cascade=CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id",insertable=false, updatable=false)
    @Access(AccessType.FIELD)
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne(targetEntity = User.class,cascade=CascadeType.REFRESH,fetch = FetchType.EAGER)
    //@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",insertable=false, updatable=false)
    @Access(AccessType.FIELD)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public ProjectMember(Long id, Long project_id, Long user_id) {
        this.id = id;
        this.project_id = project_id;
        this.user_id = user_id;
    }

    public ProjectMember() {

    }
}
