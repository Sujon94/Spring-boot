package com.example.crud.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private long id;

    public User(){

    }

    public User(String name, String email, String password, LocalDateTime created_at) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Column(name = "[name]")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @OneToMany(mappedBy = "user")
    private List<ProjectMember> projectMember;

/*@OneToMany(targetEntity = ProjectMember.class, mappedBy = "user_id",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectMember> projectMember;

    public List<ProjectMember> getProjectMember() {
        return projectMember;
    }

    public void setProjectMember(List<ProjectMember> projectMember) {
        this.projectMember = projectMember;
    }*/
}
