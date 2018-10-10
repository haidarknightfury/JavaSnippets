package com.example.snippets.threading.basic;

import java.io.PrintStream;

import org.apache.commons.lang.RandomStringUtils;

public class Thread2 {

    public static void main(String[] arg) {

        Thread[] array = new Thread[30];

        Runnable runnable = () -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String randomStr = RandomStringUtils.random(8, 65, 90, true, true);
            System.out.println("THREAD RUNNING AT" + System.nanoTime() + ":" + randomStr);
        };

        for (int i = 0; i < array.length; i++) {
            array[i] = new Thread(runnable);
        }
        
        while (true) {
            try {
                for (int i = 0; i < array.length; i++) {
                    array[i].start();
                }

                for (int i = 0; i < array.length; i++) {
                    array[i] = new Thread(runnable);
                }

            } catch (Exception e) {
                e.printStackTrace(new PrintStream(System.out));
            }
        }

    }
}
