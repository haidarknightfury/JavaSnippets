package com.example.snippets.threading.intro.synchronising;

public class TargetFile {

    public void call(int threadId) {
        System.out.println("Calling thread from " + threadId);
    }
}
