package com.example.crud.service.impl;

import com.example.crud.service.ProjectMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.crud.model.ProjectMember;
import com.example.crud.repository.ProjectMemberRepository;

@Service
public class ProjectMembersServiceImpl implements ProjectMembersService {

    @Autowired
    private ProjectMemberRepository projectMembersRepository;

    @Override
    public ProjectMember findById(Long id){
        return projectMembersRepository.findById(id).orElse(null);
    }

    @Override
    public Page<ProjectMember> findByPage(int pageNum, int pageSize) {
        return projectMembersRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @Override
    public void insert(ProjectMember projectMembers){
        projectMembersRepository.save(projectMembers);
    }

    @Override
    public void update(ProjectMember projectMembers){
        projectMembersRepository.save(projectMembers);
    }

    @Override
    public void deleteById(Long id){
        projectMembersRepository.deleteById(id);
    }

}
