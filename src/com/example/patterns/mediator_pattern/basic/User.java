package com.example.patterns.mediator_pattern.basic;

public class User {

    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showMessage(String message) {
        Chatroom.showMessage(this, message);
    }

    @Override
    public String toString() {
        return "User [name=" + this.name + "]";
    }

}
