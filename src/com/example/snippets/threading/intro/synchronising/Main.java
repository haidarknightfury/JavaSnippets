package com.example.snippets.threading.intro.synchronising;

public class Main {

    public static void main(String[] args) {

        // Single instance of target obj
        // All threads have the same target + same reference
        // Only one thread get synchronised object at a time
        TargetFile targetObj = new TargetFile();

        MyThread t1 = new MyThread(1, targetObj);
        MyThread t2 = new MyThread(2, targetObj);
        MyThread t3 = new MyThread(3, targetObj);

        t1.start();
        t2.start();
        t3.start();
    }

}
