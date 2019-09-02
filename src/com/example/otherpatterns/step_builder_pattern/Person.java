package com.example.otherpatterns.step_builder_pattern;

import java.util.List;

public class Person {

    private String name;
    private String othernames;
    private String username;
    private List<String> roles;
    private Integer age;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOthernames() {
        return this.othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", othernames=" + this.othernames + ", username=" + this.username + ", roles=" + this.roles + ", age=" + this.age + "]";
    }

}
