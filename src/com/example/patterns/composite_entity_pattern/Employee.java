package com.example.patterns.composite_entity_pattern;

public class Employee {

    private String name;
    private String jobSuccess;

    public String getJobSuccess() {
        return this.jobSuccess;
    }

    public String getName() {
        return this.name;
    }

    public void setJobSuccess(String jobSuccess) {
        this.jobSuccess = jobSuccess;
    }

    public void setName(String name) {
        this.name = name;
    }

}
