package com.example.crud.controller;

import com.example.crud.model.Project;
import com.example.crud.repository.ProjectRepository;
import com.example.crud.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
/*@RestController*/
/*@RequestMapping("/api")*/
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    public String getAll(Model model, @Param("keyword") String keyword){
        try{
            List<Project> projects = new ArrayList<Project>();

            if (keyword == null){
                projectRepository.findAll().forEach(projects::add);
            }else{
                projectRepository.findByNameContainingIgnoreCase(keyword).forEach(projects::add);
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("projects",projects);
        }catch (Exception e){
            model.addAttribute("message", e.getMessage());
        }
        return "projects";
    }
    @GetMapping("/project/new")
    public String addProject(Model model){
        try{
            return "Hello world";
        }catch (Exception e){
            return e.getMessage();
        }

        /*Project project = new Project();
        model.addAttribute("project",project);
        model.addAttribute("pageTitle","Create new Project.");

        return "project_form";*/
    }
    @PostMapping("/project/save")
    public String saveProject(Project project, RedirectAttributes redirectAttributes){
        try{
            projectRepository.save(project);

            redirectAttributes.addFlashAttribute("message","The Project has been saved successfully");
        }catch (Exception e){
            redirectAttributes.addAttribute("message",e.getMessage());
        }
        return "redirect:/projects";
        /*try{
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
        }*/
    }

    @GetMapping("/project/{id}")
    public String editProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Project project = projectRepository.findById(id).get();

            model.addAttribute("project",project);
            model.addAttribute("pageTitle","Edit Project : "+project.getName());
            return "project_form";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/projects";
        }
    }

    @GetMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try{
            projectRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "The Project is removed successfully.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/tutorials";
    }

    @GetMapping("/projects/{id}/published/{status}")
    public String updateProjectPublishedStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean published,
                                                Model model, RedirectAttributes redirectAttributes) {

        return "redirect:/projects";
    }
}
