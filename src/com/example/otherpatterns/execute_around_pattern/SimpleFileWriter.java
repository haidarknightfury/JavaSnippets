package com.example.otherpatterns.execute_around_pattern;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter {

    public SimpleFileWriter(String fileName, FileWriterAction action) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            action.writeFile(writer);
        }
    }

}
