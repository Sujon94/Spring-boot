package com.example.prmgs.repository;

import com.example.prmgs.dto.ProjectMemberDto;
import com.example.prmgs.dto.UserDto;
import com.example.prmgs.model.ProjectMember;
import com.example.prmgs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long> {
    @Query(value = "SELECT new com.example.prmgs.dto.UserDto(u.id, u.userName, u.email, p.project_id, p.id) FROM User u RIGHT JOIN ProjectMember p ON p.user_id = u.id WHERE p.project_id=:id")
    List<UserDto> fetchMembersByProject(Long id);
}
