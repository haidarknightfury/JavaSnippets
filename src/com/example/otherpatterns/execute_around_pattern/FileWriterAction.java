package com.example.otherpatterns.execute_around_pattern;

import java.io.FileWriter;
import java.io.IOException;

@FunctionalInterface
public interface FileWriterAction {

    void writeFile(FileWriter writer) throws IOException;
}
