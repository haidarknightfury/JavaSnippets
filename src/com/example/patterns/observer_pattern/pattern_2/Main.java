package com.example.patterns.observer_pattern.pattern_2;

public class Main {
    public static void main(String[] args) {

        Topic topic = new Topic();
        Observer obs1 = new Subscriber("OBS1");
        Observer obs2 = new Subscriber("OBS2");

        topic.register(obs1);
        topic.register(obs2);

        obs1.setSubject(topic);
        obs2.setSubject(topic);

        obs1.update();

        topic.postMessage("HELLO BOY");
    }
}
