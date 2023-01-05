package com.example.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "project_members")
public class ProjectMember {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
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
