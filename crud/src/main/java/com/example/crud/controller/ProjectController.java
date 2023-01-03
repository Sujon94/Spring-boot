package com.example.crud.controller;

import com.example.crud.model.Project;
import com.example.crud.repository.ProjectRepository;
import com.example.crud.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @PostMapping("/project")
    public ResponseEntity<Object> createProject(@RequestBody Project project){
        try{
            Project data = projectRepository
                    .save(
                            new Project(
                                    project.getName(),
                                    project.getIntro(),
                                    project.getStart_at(),
                                    project.getEnd_at(),
                                    project.getUser_id(),
                                    project.getStatus(),
                                    project.getCreated_at()
                            ));
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
