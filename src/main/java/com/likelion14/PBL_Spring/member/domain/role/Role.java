package com.likelion14.PBL_Spring.member.domain.role;


import com.likelion14.PBL_Spring.member.domain.policy.SubmissionPolicy;

public abstract class Role {
    public abstract SubmissionPolicy submissionPolicy();

    public abstract String getInfo();
    public abstract String roleName();

    private String name;
    private String major;
    private int generation;
    private String part;

    protected Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.submissionPolicy();
    }

    public final String getName() { return name; }

    public final String getMajor() { return major; }

    public final int getGeneration() { return generation; }

    public final String getPart() { return part; }

    public boolean canSubmitAssignment() { return this.submissionPolicy().canSubmit(); }
}
