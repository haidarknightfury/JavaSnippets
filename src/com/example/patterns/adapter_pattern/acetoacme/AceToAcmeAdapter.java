package com.example.patterns.adapter_pattern.acetoacme;

public class AceToAcmeAdapter implements AcmeInterface {

    Ace ace;
    String fname;
    String lname;

    public AceToAcmeAdapter(Ace ace) {
        this.ace = ace;
        this.fname = ace.name.split(" ")[0];
        this.lname = ace.name.split(" ")[1];
    }

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
