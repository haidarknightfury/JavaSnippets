package com.example.otherpatterns.event_driven_arch_pattern.framework;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher {

    private Map<Class<? extends Event>, Handler<? extends Event>> handlers;

    public EventDispatcher() {
        this.handlers = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
        this.handlers.put(eventType, handler);
    }

    public <E extends Event> void dispatch(E event) {
        Handler<Event> handler = (Handler<Event>) this.handlers.get(event.getClass());
        if (handler != null) {
            handler.onEvent(event);
        }
    }

}
