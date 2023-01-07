package com.example.crud.repository;

import com.example.crud.dto.UserDto;
import com.example.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.crud.dto.UserDto(u.id, u.name, u.email) FROM User u RIGHT JOIN ProjectMember p ON p.project_id=:id")
    List<UserDto> fetchMembersByProject(Long id);
}
