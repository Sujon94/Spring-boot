package com.example.prmgs.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private Long project_id;
    private Long projectMemberId;

    public UserDto(Long userId, String name){
        this.userId = userId;
        this.name = name;
    }

    public UserDto(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public UserDto(Long userId, String name, String email, Long project_id, Long projectMemberId) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.project_id = project_id;
        this.projectMemberId = projectMemberId;
    }

    /*
    public UserDto(){

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(Long projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }*/
}
