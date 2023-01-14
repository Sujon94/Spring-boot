package com.example.prmgs.repository;

import com.example.prmgs.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByNameContainingIgnoreCase(String keyword);
}
