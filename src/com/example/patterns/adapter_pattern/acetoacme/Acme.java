package com.example.patterns.adapter_pattern.acetoacme;

public class Acme implements AcmeInterface {

    String fname;
    String lname;

    @Override
    public String getFname() {
        return this.fname;
    }

    @Override
    public String getLname() {
        return this.lname;
    }

    @Override
    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public void setLname(String sname) {
        this.lname = sname;
    }

}
