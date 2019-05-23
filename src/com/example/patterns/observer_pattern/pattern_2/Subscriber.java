package com.example.patterns.observer_pattern.pattern_2;

public class Subscriber implements Observer {

    private String name;
    private Subject topic;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }

    @Override
    public void update() {
        String msg = (String) this.topic.getUpdate(this);
        if (msg == null) {
            System.out.println("NO NEW MESSAGE");
        } else {
            System.out.println(" Consuming msg " + msg);
        }
    }

}
