package com.example.snippets.threading.thread_local;

public class Example1 {

    /**
     * A new instance of thread local is created for each thread - even if it is initialised with the same object
     * A new instance will always be created
     */
    private static ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    // Same as extending the ThreadLocal without
    ThreadLocal<String> str = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "";
        }
    };

    static IncrementerThread incremer = new IncrementerThread(counter) {
        @Override
        public void run() {
            System.out.println("hello");
        }
    };

    public static void main(String[] args) {
        IncrementerThread t1 = new IncrementerThread(counter);
        IncrementerThread t2 = new IncrementerThread(counter);

        t1.start();
        t2.start();

        incremer.start();

    }

}
