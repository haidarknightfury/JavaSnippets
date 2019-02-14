package com.example.ruleengine.entity;

public class Fake {

    private String age;
    private String fname;
    private String sname;

    public Fake(String age, String fname, String sname) {
        this.age = age;
        this.fname = fname;
        this.sname = sname;
    }

    public String getAge() {
        return this.age;
    }

    public String getFname() {
        return this.fname;
    }

    public String getSname() {
        return this.sname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Fake [age=" + this.age + ", fname=" + this.fname + ", sname=" + this.sname + "]";
    }

}
