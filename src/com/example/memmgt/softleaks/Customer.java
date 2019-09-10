package com.example.memmgt.softleaks;

public class Customer {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.name;
    }

    public Customer(String name) {
        super();
        this.name = name;
    }

}
