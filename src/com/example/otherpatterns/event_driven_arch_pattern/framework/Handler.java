package com.example.otherpatterns.event_driven_arch_pattern.framework;

public interface Handler<E extends Event> {

    void onEvent(E event);
}
