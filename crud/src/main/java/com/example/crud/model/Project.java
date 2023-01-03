package com.example.crud.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "intro")
    private String intro;

    @Column(name = "start_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime start_at;

    @Column(name = "end_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime end_at;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "status")
    private long status;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime created_at;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deleted_at;






}
