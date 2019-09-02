package com.example.otherpatterns.reactor_pattern;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class AbstractNioChannel {

    private final SelectableChannel channel;
    private final ChannelHandler handler;
    private final Map<SelectableChannel, Queue<Object>> channelToPendingWrites = new ConcurrentHashMap<>();
    private NioReactor reactor;

    public AbstractNioChannel(ChannelHandler handler, SelectableChannel channel) {
        this.handler = handler;
        this.channel = channel;
    }

    void setReactor(NioReactor nioReactor) {
        this.reactor = nioReactor;
    }

    public SelectableChannel getJavaChannel() {
        return this.channel;
    }

    public abstract void bind() throws IOException;

    public abstract Object read(SelectionKey key) throws IOException;

    public ChannelHandler getHandler() {
        return this.handler;
    }

    void flush(SelectionKey key) throws IOException {
        Queue<Object> pendingWrites = this.channelToPendingWrites.get(key);
        while (true) {
            Object pendingWrite = pendingWrites.poll();
            if (pendingWrite == null) {
                this.reactor.changeOps(key, SelectionKey.OP_READ);
                break;
            }
            this.doWrite(pendingWrites, key);
        }

    }

    protected abstract void doWrite(Queue<Object> pendingWrites, SelectionKey key);

    public void write(Object data, SelectionKey key) {
        Queue<Object> pendingWrites = this.channelToPendingWrites.get(key.channel());
        if (pendingWrites == null) {
            synchronized (this.channelToPendingWrites) {
                pendingWrites = this.channelToPendingWrites.get(key.channel());
                if (pendingWrites == null) {
                    pendingWrites = new ConcurrentLinkedQueue<>();
                    this.channelToPendingWrites.put(key.channel(), pendingWrites);
                }
            }
        }
        pendingWrites.add(data);
        this.reactor.changeOps(key, SelectionKey.OP_WRITE);
    }

}
