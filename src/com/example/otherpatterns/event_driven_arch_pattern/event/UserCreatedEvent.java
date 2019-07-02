package com.example.otherpatterns.event_driven_arch_pattern.event;

import com.example.otherpatterns.event_driven_arch_pattern.model.User;

public class UserCreatedEvent extends AbstractEvent {
    private User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
