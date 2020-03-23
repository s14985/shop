package com.tin.shop.model;

public enum Roles {
    USER ("user"),
    ADMIN ("admin");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
