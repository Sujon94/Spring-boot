package com.example.prmgs.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class ProjectDto {
    /*private Long projectId;
    private String projectName;*/

    private static final long serialVersionUID = 1L;
    private Long id;

    @NotBlank(message = "Project name is mandatory")
    private String name;

    @NotBlank(message = "Project intro is mandatory")
    private String intro;

    private String start_at;

    private String end_at;

    private Long user_id;

    private Long status_id;

    public ProjectDto(){

    }
    public ProjectDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    /*
     public ProjectDto(Long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }*/
}
