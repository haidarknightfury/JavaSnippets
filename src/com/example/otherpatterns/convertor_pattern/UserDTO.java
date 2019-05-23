package com.example.otherpatterns.convertor_pattern;

public class UserDTO {
    private String name;
    private String username;
    private String password;

    public UserDTO(String name, String username, String password) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO [name=" + this.name + ", username=" + this.username + ", password=" + this.password + "]";
    }
}
