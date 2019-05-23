package com.example.otherpatterns.feature_toggle.user;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [name=" + this.name + "]";
    }

}
