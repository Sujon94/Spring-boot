package com.example.prmgs.controller;

import com.example.prmgs.model.Project;
import com.example.prmgs.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ai/v1/projects")
public class ProjectRestController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("")
    public ResponseEntity<List<Project>> getAllTutorials(){
        try{
            List<Project> projects = new ArrayList<Project>();

            if (projects.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(projects,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
