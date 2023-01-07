package com.example.crud.controller;

import com.example.crud.model.LStatus;
import com.example.crud.model.Project;
import com.example.crud.repository.LStatusRepository;
import com.example.crud.repository.ProjectRepository;
import org.apache.tomcat.util.net.IPv6Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;

@Controller
/*@RestController*/
/*@RequestMapping("/api")*/
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    LStatusRepository lStatusRepository;

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
        Project project = new Project();
        //List<LStatus> lStatuses = new ArrayList<>(lStatusRepository.findAll());

        model.addAttribute("pageTitle","Create new Project.");
        //model.addAttribute("lstatuses",lStatuses);
        model.addAttribute("project",project);

        return "project_form";
    }
    @PostMapping("/project/save")
    public String saveProject(@ModelAttribute("Project") Project project, Model model, RedirectAttributes redirectAttributes){
        try{
            Project _project = new Project();
            String message = "The Project has been saved successfully";
            if (project.getId() != null) {
                _project = projectRepository.findById(project.getId()).get();
                message = "The Project has been updated successfully";
                model.addAttribute("project",_project);
            }
            _project.setName(project.getName());
            _project.setIntro(project.getIntro());
            _project.setStart_at(project.getStart_at());
            _project.setEnd_at(project.getEnd_at());
            _project.setUser_id(project.getUser_id());

            projectRepository.save(_project);

            redirectAttributes.addFlashAttribute("message",message);
        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }
        return "redirect:/projects";
       /* try{
            Project _project = new Project();
            _project.setName(project.getName());
            _project.setIntro(project.getIntro());
            _project.setStart_at(project.getStart_at());
            _project.setEnd_at(project.getEnd_at());
            _project.setUser_id(project.getUser_id());

            projectRepository.save(project);

            redirectAttributes.addFlashAttribute("message","The Project has been saved successfully");
        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }
        return "redirect:/projects";*/
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

    @PostMapping("/project/update")
    public String updateProject(@ModelAttribute("Project") Project project,Model model, RedirectAttributes redirectAttributes){
        try{
            Project _project = new Project();
            String message = "The Project has been saved successfully";
            if (project.getId() != null) {
                _project = projectRepository.findById(project.getId()).get();
                message = "The Project has been updated successfully";
                model.addAttribute("project",_project);
            }
            _project.setName(project.getName());
            _project.setIntro(project.getIntro());
            _project.setStart_at(project.getStart_at());
            _project.setEnd_at(project.getEnd_at());
            _project.setUser_id(project.getUser_id());

            projectRepository.save(_project);

            redirectAttributes.addFlashAttribute("message",message);
        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }
        return "project_form";
    }

    @GetMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            projectRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "The Project is removed successfully.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}/published/{status}")
    public String updateProjectPublishedStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean published,
                                                Model model, RedirectAttributes redirectAttributes) {

        return "redirect:/projects";
    }
}
