package com.example.otherpatterns.reactor_pattern;

import java.nio.channels.SelectionKey;

public interface ChannelHandler {

    void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key);
}
