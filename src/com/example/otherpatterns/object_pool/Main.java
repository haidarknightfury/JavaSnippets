package com.example.otherpatterns.object_pool;

public class Main {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection c1 = connectionPool.checkout();
        System.out.println(c1);
        Connection c2 = connectionPool.checkout();
        System.out.println(c2);
        Connection c3 = connectionPool.checkout();
        System.out.println(c3);
        connectionPool.checkIn(c3);
        Connection c4 = connectionPool.checkout();
        System.out.println(c4);

    }
}
