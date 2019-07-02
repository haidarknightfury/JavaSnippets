package com.example.otherpatterns.event_driven_arch_pattern.handler;

import com.example.otherpatterns.event_driven_arch_pattern.event.UserUpdateEvent;
import com.example.otherpatterns.event_driven_arch_pattern.framework.Handler;

public class UserUpdateEventHandler implements Handler<UserUpdateEvent> {

    @Override
    public void onEvent(UserUpdateEvent event) {
        System.out.println("USER UPDATE EVENT OCCURED : " + event.getUser().getUsername());
    }

}
