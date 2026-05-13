package com.likelion14.PBL_Spring.member.domain.role;


import com.likelion14.PBL_Spring.member.domain.policy.LionSubmissionPolicy;
import com.likelion14.PBL_Spring.member.domain.policy.SubmissionPolicy;

public class Lion extends Role
{
    private String Snum;

    public Lion(String name, String major, int generation, String part, String Snum) {
        super(name, major, generation, part);
        this.Snum = Snum;
    }

    @Override
    public SubmissionPolicy submissionPolicy() {
    return new LionSubmissionPolicy();
    }

    @Override
    public String getInfo() {
        return "이름: " + getName() + "| 전공: " + getMajor() + "| 기수: " + getGeneration() + "| 파트: " + getPart() + "\n 학번: " + Snum;
    }

    @Override
    public String roleName() { return "아기사자"; }
}
