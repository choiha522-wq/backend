package com.likelion14.PBL_Spring.member.dto;

import com.likelion14.PBL_Spring.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
public class MemberResponse {
    private Long id;
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;
    private  String position;

    public static MemberResponse from(Member entity) {
        MemberResponse response = new MemberResponse();
        response.id =  entity.getId();
        response.name = entity.getName();
        response.major = entity.getMajor();
        response.generation = entity.getGeneration();
        response.part = entity.getPart();
        response.roleName = entity.getRoleType().getDisplayName();
        response.studentId = entity.getStudentId();
        response.position = entity.getPosition();
        return response;
    }
}
