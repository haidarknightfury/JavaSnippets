package com.example.otherpatterns.event_driven_arch_pattern.framework;

public interface Event {

    Class<? extends Event> getType();
}
