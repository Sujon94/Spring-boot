package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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
}
