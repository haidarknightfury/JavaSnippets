package com.example.otherpatterns.data_bus_pattern;

import java.util.HashSet;
import java.util.Set;

public class DataBus {

    private static final DataBus INSTANCE = new DataBus();

    public static DataBus getInstance() {
        return INSTANCE;
    }

    private final Set<Member> listeners = new HashSet<>();

    public void publish(final DataType event) {
        event.setDataBus(this);
        this.listeners.forEach(listener -> listener.accept(event));
    }

    public void subscribe(Member member) {
        this.listeners.add(member);
    }

    public void unsubscribe(Member member) {
        this.listeners.remove(member);
    }
}
