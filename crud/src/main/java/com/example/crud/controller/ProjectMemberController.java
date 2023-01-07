package com.example.crud.controller;

import com.example.crud.dto.UserDto;
import com.example.crud.model.ProjectMember;
import com.example.crud.model.User;
import com.example.crud.repository.ProjectMemberRepository;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProjectMemberController {
    @Autowired
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;
    public Long id;

    @GetMapping("/project_members/{id}")
    public String getAllMembersOfaProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
        try{
            List<UserDto> projectMemberList = new ArrayList<>();
            projectMemberRepository.fetchMembersByProject(id).forEach(projectMemberList::add);
            model.addAttribute("pageTitle","Project members");
            model.addAttribute("members",projectMemberList);
        }catch (Exception e){
            model.addAttribute("message", e.getMessage());
        }
        return "project_members";
    }


    @GetMapping("/project_member/add")
    public String addNewMembers(@PathVariable("project_id") Long id, Model model, RedirectAttributes redirectAttributes){
        try{
            ProjectMember _projectMember = new ProjectMember();


        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }

        return "assign_member";
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
