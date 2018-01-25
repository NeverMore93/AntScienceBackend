package com.as.backend.antscience.enums;

public enum Authority {
    GENERAL("general"),
    ADMIN("admin");
    private final String authority;
    Authority(final String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return authority;
    }

}
