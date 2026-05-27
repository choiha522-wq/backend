package com.likelion14.PBL_Spring.member.domain;

public enum RoleType {
    Lion("아기사자"),
    Staff("운영진");

    private final String displayName;

    RoleType(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return displayName; }
}
