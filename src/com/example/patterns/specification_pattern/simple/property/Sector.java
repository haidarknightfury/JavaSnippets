package com.example.patterns.specification_pattern.simple.property;

public enum Sector {

    IT("Information Technology"), MGT("Management");

    private String title;

    Sector(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
