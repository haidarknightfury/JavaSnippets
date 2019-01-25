package com.example.snippets.threading.spliterator;

public class Utility {

    private String name;

    public Utility(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Utility [name=" + this.name + "]";
    }

}
