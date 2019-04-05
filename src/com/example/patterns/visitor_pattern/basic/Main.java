package com.example.patterns.visitor_pattern.basic;

public class Main {

    public static void main(String[] args) {
        Item items[] = new Item[] { new Notebook(200, 250), new Pen(20, 2) };
        VisitorImpl visitorImpl = new VisitorImpl();
        int total = 0;
        for (Item item : items) {
            total += item.accept(visitorImpl);
        }
        System.out.println(total);
    }
}
