package com.example.otherpatterns.event_driven_arch_pattern;

import com.example.otherpatterns.event_driven_arch_pattern.event.BakaEvent;
import com.example.otherpatterns.event_driven_arch_pattern.event.UserCreatedEvent;
import com.example.otherpatterns.event_driven_arch_pattern.event.UserUpdateEvent;
import com.example.otherpatterns.event_driven_arch_pattern.framework.EventDispatcher;
import com.example.otherpatterns.event_driven_arch_pattern.handler.UserCreatedEventHandler;
import com.example.otherpatterns.event_driven_arch_pattern.handler.UserUpdateEventHandler;
import com.example.otherpatterns.event_driven_arch_pattern.model.User;

public class Main {

    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new EventDispatcher();
        eventDispatcher.registerHandler(UserUpdateEvent.class, new UserUpdateEventHandler());
        eventDispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
        eventDispatcher.registerHandler(BakaEvent.class, (bakaEvent) -> System.out.println(bakaEvent.getUser().getUsername() + " BAKAAAA"));

        User user = new User("haidar");
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        eventDispatcher.dispatch(userCreatedEvent);

        user.setUsername("baka");
        UserUpdateEvent userUpdateEvent = new UserUpdateEvent(user);
        eventDispatcher.dispatch(userUpdateEvent);

        user.setUsername("HAIDAR");
        userUpdateEvent = new UserUpdateEvent(user);
        eventDispatcher.dispatch(userUpdateEvent);

        eventDispatcher.dispatch(new BakaEvent(user));
    }
}
