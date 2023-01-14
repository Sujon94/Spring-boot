package com.example.prmgs.model;

import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class AssignMemberForm {
    private Long projectId;
    private List<Long> users;

}
