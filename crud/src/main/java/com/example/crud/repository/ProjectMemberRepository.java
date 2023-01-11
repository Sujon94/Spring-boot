package com.example.crud.repository;

import com.example.crud.dto.ProjectMemberDto;
import com.example.crud.dto.UserDto;
import com.example.crud.model.ProjectMember;
import com.example.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long> {
    @Query(value = "SELECT new com.example.crud.dto.UserDto(u.id, u.userName, u.email, p.project_id, p.id) FROM User u RIGHT JOIN ProjectMember p ON p.user_id = u.id WHERE p.project_id=:id")
    List<UserDto> fetchMembersByProject(Long id);
}
