package com.example.crud.controller;

import com.example.crud.dto.ProjectDto;
import com.example.crud.dto.UserDto;
import com.example.crud.model.AssignMemberForm;
import com.example.crud.model.Project;
import com.example.crud.model.ProjectMember;
import com.example.crud.model.User;
import com.example.crud.repository.ProjectMemberRepository;
import com.example.crud.repository.ProjectRepository;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class ProjectMemberController {
    @Autowired
    ProjectMemberRepository projectMemberRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;
    public Long id;

    @GetMapping("/project_members/{id}")
    public String getAllMembersOfaProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
        try{
            List<UserDto> projectMemberList = new ArrayList<>();
            projectMemberRepository.fetchMembersByProject(id).forEach(projectMemberList::add);

            List<UserDto> userDtoList = new ArrayList<>();
            userRepository.fetchMembersNotInProjectMember(id).forEach(userDtoList::add);

            Optional<Project> project = projectRepository.findById(id);
            ProjectDto projectDto = new ProjectDto(project.get().getId(), project.get().getName());

            model.addAttribute("pageTitle","Assign members to the "+projectDto.getProjectName());
            model.addAttribute("assignMemberForm",new AssignMemberForm());
            model.addAttribute("project", projectDto);
            model.addAttribute("projectMembers", userDtoList);
            model.addAttribute("members", projectMemberList);

        }catch (Exception e){
            model.addAttribute("message", e.getMessage());
        }
        return "project_members";
    }

    @PostMapping("/project_members/assign")
    public String addNewMembers(@ModelAttribute("AssignMemberForm") AssignMemberForm assignMemberForm, Model model, RedirectAttributes redirectAttributes){
        try{
            for (Long id: assignMemberForm.getUsers()){
                ProjectMember _projectMember = new ProjectMember();
                _projectMember.setProject_id(assignMemberForm.getProjectId());
                _projectMember.setUser_id(id);
                projectMemberRepository.save(_projectMember);
            }
            String message = "Members has been assigned successfully";
            redirectAttributes.addFlashAttribute("message",message);
        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }

        return "redirect:/project_members/"+assignMemberForm.getProjectId();
    }

    @GetMapping("/project_member/remove/{id}")
    public String removeMember(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            ProjectMember projectMember = projectMemberRepository.findById(id).get();
            this.id = projectMember.getProject_id();

            projectMemberRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "The Member is removed successfully.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/project_members/"+this.id;
    }

}
