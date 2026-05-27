package com.likelion14.PBL_Spring.member.service;

import com.likelion14.PBL_Spring.member.domain.Member;
import com.likelion14.PBL_Spring.member.domain.RoleType;
import com.likelion14.PBL_Spring.member.dto.LionCreateRequest;
import com.likelion14.PBL_Spring.member.dto.LionUpdateRequest;
import com.likelion14.PBL_Spring.member.dto.StaffCreateRequest;
import com.likelion14.PBL_Spring.member.dto.StaffUpdateRequest;
import com.likelion14.PBL_Spring.member.repository.MemberRepository;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) { this.repository = repository; }

    public Member searchByName (String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }


    public Member createLion(LionCreateRequest request) {
        if (repository.existsByName(request.getName())) {
            return null;
        }
        Member member = Member.builder()
                .name(request.getName())
                .major(request.getMajor())
                .generation(request.getGeneration())
                .part(request.getPart())
                .roleType(RoleType.Lion)
                .studentId(request.getStudentId())
                .position("아기사자")
                .build();

        return repository.save(member);
    }

    public Member createStaff(StaffCreateRequest request) {
        if (repository.existsByName(request.getName())) {
            return null;
        }
        Member member = new Member(request.getName(), request.getMajor(), request.getPart(),
                request.getGeneration(), RoleType.Staff, null, request.getPosition());
        return repository.save(member);
    }

    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId((request.getStudentId()));
        return repository.save(member);
        }


    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition((request.getPosition()));
        return repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteMember(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
 }
