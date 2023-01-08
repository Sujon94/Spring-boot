package com.example.crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "l_status")
public class LStatus {
    public LStatus() {
    }
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public LStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "lStatus")
    private List<Project> project;
}
