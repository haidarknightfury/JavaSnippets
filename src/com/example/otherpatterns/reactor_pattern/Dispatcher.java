package com.example.otherpatterns.reactor_pattern;

import java.nio.channels.SelectionKey;

public interface Dispatcher {

    void onChannelReadEvent(AbstractNioChannel channel, Object reObject, SelectionKey key);

    void stop() throws InterruptedException;

}
