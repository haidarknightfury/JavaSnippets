package com.example.snippets.threading.thread_local_2;

public class MyThreadLocal {

    public static final ThreadLocal<Context> userThreadLocal = new ThreadLocal<Context>();

    public static void set(Context user) {
        userThreadLocal.set(user);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static Context get() {
        return userThreadLocal.get();
    }

}
