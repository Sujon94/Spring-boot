package com.example.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ProjectMember> projectMember;

    public User(String name, String email, String password, LocalDateTime created_at) {
    }
}
