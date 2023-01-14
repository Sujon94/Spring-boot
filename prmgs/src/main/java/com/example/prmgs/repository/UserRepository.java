package com.example.prmgs.repository;

import com.example.prmgs.dto.UserDto;
import com.example.prmgs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.prmgs.dto.UserDto(u.id, u.userName, u.email) FROM User u RIGHT JOIN ProjectMember p ON p.project_id=:id")
    List<UserDto> fetchMembersByProject(Long id);

    @Query("SELECT new com.example.prmgs.dto.UserDto(u.id, u.userName) FROM User u WHERE u.id NOT IN (SELECT p.user_id FROM ProjectMember p WHERE p.project_id = :projectId)")
    List<UserDto> fetchMembersNotInProjectMember(Long projectId);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    User findByUserName(String username);
    boolean existsByEmail(String email);
}
