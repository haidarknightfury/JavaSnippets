package com.example.snippets.file.stream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriter {

    public static void main(String[] args) {

        // Reading text file + adapt to character set
        try (FileReader in = new FileReader("C:\\NDC\\JavaSnippets\\files\\textfile.txt");
                FileWriter out = new FileWriter("C:\\NDC\\JavaSnippets\\files\\output.txt")) {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
