package com.example.prmgs.controller;

import com.example.prmgs.dto.ProjectDto;
import com.example.prmgs.model.LStatus;
import com.example.prmgs.model.Project;
import com.example.prmgs.repository.LStatusRepository;
import com.example.prmgs.repository.ProjectRepository;
import com.example.prmgs.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    LStatusRepository lStatusRepository;

    @GetMapping("/list")
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
        return "project/projects";
    }
    @GetMapping("/new")
    public String addProject(Model model){
        ProjectDto projectDto = new ProjectDto();
        ArrayList<Long> allowedStatus = new ArrayList<>();
        allowedStatus.add(1L);
        allowedStatus.add(2L);
        List<LStatus> lStatuses = lStatusRepository.findAllByIdIn(allowedStatus);

        model.addAttribute("pageTitle","Create new Project.");
        model.addAttribute("submitBtnName","Save");
        model.addAttribute("lStatuses",lStatuses);
        model.addAttribute("projectDto",projectDto);

        return "project/project_form";
    }
    @PostMapping("/save")
    public String saveProject(@Valid @ModelAttribute("projectDto") ProjectDto project, Model model, RedirectAttributes redirectAttributes){
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
            _project.setStart_at(Util.strToDt(project.getStart_at()));
            _project.setEnd_at(Util.strToDt(project.getEnd_at()));
            _project.setUser_id(project.getUser_id());
            _project.setStatus_id(project.getStatus_id());

            projectRepository.save(_project);

            redirectAttributes.addFlashAttribute("message",message);
        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Project project = projectRepository.findById(id).get();
            List<LStatus> lStatuses = lStatusRepository.findAll();

            ProjectDto projectDto = new ProjectDto();
            projectDto.setId(project.getId());
            projectDto.setName(project.getName());
            projectDto.setIntro(project.getIntro());
            projectDto.setStart_at(Util.dtToStr(project.getStart_at()));
            projectDto.setEnd_at(Util.dtToStr(project.getEnd_at()));
            projectDto.setUser_id(project.getUser_id());
            projectDto.setStatus_id(project.getStatus_id());

            model.addAttribute("pageTitle","Edit Project : "+project.getName());
            model.addAttribute("projectDto",projectDto);
            model.addAttribute("lStatuses",lStatuses);
            model.addAttribute("submitBtnName","Update");

            return "project/project_form";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:list";
        }
    }

    @PostMapping("/update")
    public String updateProject(@Valid @ModelAttribute("projectDto") ProjectDto project,Model model, RedirectAttributes redirectAttributes){
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
            _project.setStart_at(Util.strToDt(project.getStart_at()));
            _project.setEnd_at(Util.strToDt(project.getEnd_at()));
            _project.setUser_id(project.getUser_id());

            projectRepository.save(_project);

            redirectAttributes.addFlashAttribute("message",message);
        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }
        return "project/project_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            projectRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "The Project is removed successfully.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/project/list";
    }

    @GetMapping("/projects/{id}/published/{status}")
    public String updateProjectPublishedStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean published,
                                                Model model, RedirectAttributes redirectAttributes) {

        return "redirect:/projects";
    }
}
