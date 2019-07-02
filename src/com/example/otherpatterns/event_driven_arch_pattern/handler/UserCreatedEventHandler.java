package com.example.otherpatterns.event_driven_arch_pattern.handler;

import com.example.otherpatterns.event_driven_arch_pattern.event.UserCreatedEvent;
import com.example.otherpatterns.event_driven_arch_pattern.framework.Handler;

public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

    @Override
    public void onEvent(UserCreatedEvent event) {
        System.out.println("NEW USER CREATED WITH USERNAME : " + event.getUser().getUsername());
    }

}
