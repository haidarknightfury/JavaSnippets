package com.example.otherpatterns.object_pool;

public class ConnectionPool extends ObjectPool<Connection> {

    @Override
    protected Connection create() {
        return new Connection();
    }

}
