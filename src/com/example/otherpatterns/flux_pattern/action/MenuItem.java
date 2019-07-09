package com.example.otherpatterns.flux_pattern.action;

public enum MenuItem {

    HOME("Home"), PRODUCTS("Products"), COMPANY("Company");
    private String title;

    private MenuItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
