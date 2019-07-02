package com.example.otherpatterns.event_driven_arch_pattern.event;

import com.example.otherpatterns.event_driven_arch_pattern.framework.Event;

public abstract class AbstractEvent implements Event {

    @Override
    public Class<? extends Event> getType() {
        return this.getClass();
    }

}
