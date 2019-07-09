package com.example.otherpatterns.flux_pattern.action;

public enum ContentItem {

    PRODUCTS("Products - Company's products"), COMPANY("Company - This page displays information about the company");

    private String title;

    private ContentItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
