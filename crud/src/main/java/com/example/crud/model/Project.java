package com.example.crud.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    public Project(){

    }

    public Project(String name, String intro, String start_at, String end_at, Long user_id, Long status_id, LocalDateTime created_at) {
        this.name = name;
        this.intro = intro;
        this.start_at = start_at;
        this.end_at = end_at;
        this.user_id = user_id;
        this.status_id = status_id;
        this.created_at = created_at;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "intro")
    private String intro;

    @Column(name = "start_at", columnDefinition = "DATE")
    private String start_at;

    @Column(name = "end_at", columnDefinition = "DATE")
    private String end_at;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "status_id")
    private Long status_id;

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime created_at;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deleted_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    @OneToMany(mappedBy = "project",cascade = CascadeType.REMOVE)
    private List<ProjectMember> projectMembers;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", insertable = false, updatable = false, referencedColumnName = "id")
    @Access(AccessType.FIELD)
    private LStatus lStatus;

    public LStatus getlStatus() {
        return lStatus;
    }

    public void setlStatus(LStatus lStatus) {
        this.lStatus = lStatus;
    }
/*@OneToOne
    @JoinColumn(name = "user_id")
    @Fetch(FetchMode.JOIN)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
*/
   /* @OneToMany
    @JoinColumn(name = "project_id")
    private List<ProjectMember> projectMember;*/
}
