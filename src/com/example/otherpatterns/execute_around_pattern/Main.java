package com.example.otherpatterns.execute_around_pattern;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SimpleFileWriter simpleFileWriter = new SimpleFileWriter("hello.txt", writer ->
            {
                writer.append("Hello  there !");
            });
    }
}
