package com.example.crud.service;

import com.example.crud.model.ProjectMember;
import org.springframework.data.domain.Page;

/**
 * 
 */
public interface ProjectMembersService {

    /**
     *
     * @param id ID
     * @return {@link ProjectMember}
     */
     ProjectMember findById(Long id);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return {@link ProjectMember}
     */
     Page<ProjectMember> findByPage(int pageNum, int pageSize);

    /**
     *
     * @param projectMembers ProjectMember
     */
    void insert(ProjectMember projectMembers);

    /**
     *
     * @param projectMembers ProjectMember
     */
    void update(ProjectMember projectMembers);

    /**
     *
     * @param id ID
     */
    void deleteById(Long id);

}
