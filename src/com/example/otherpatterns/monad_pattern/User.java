package com.example.otherpatterns.monad_pattern;

public class User {
    private String name;
    private int age;
    private Sex sex;
    private String email;

    public User(String name, int age, Sex sex, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User [name=" + this.name + ", age=" + this.age + ", sex=" + this.sex + ", email=" + this.email + "]";
    }

}
