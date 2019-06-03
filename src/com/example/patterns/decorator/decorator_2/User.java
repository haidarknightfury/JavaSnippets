package com.example.patterns.decorator.decorator_2;

public class User implements IUser {

    private final String username;
    private final String password;

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUserName() {
        return this.username;
    }

    @Override
    public String toString() {
        return "User [username=" + this.username + ", password=" + this.password + "]";
    }

}
