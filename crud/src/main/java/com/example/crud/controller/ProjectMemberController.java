package com.example.crud.controller;

import com.example.crud.model.ProjectMember;
import com.example.crud.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProjectMemberController {
    @Autowired
    ProjectMemberRepository projectMemberRepository;

    @GetMapping("/project_members/{project_id}")
    public String getAllMembersOfaProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){

        return "project_members";
    }

    @GetMapping("/project_members/add/{project_id}")
    public String addNewMembers(@ModelAttribute("ProjectMember")ProjectMember projectMember, Model model, RedirectAttributes redirectAttributes){
        try{
            ProjectMember _projectMember = new ProjectMember();

        }catch (Exception e){
            redirectAttributes.addAttribute("message","Something error.");
        }

        return "assign_member";
    }

}
