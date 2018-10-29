package com.example.snippets.file.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// Managing memory + managing large files
// Wrap around fileReader/Writer
public class BufferedStream {
    public static void main(String[] args) {

        // Reading text file
        try (BufferedReader in = new BufferedReader(new FileReader("C:\\NDC\\JavaSnippets\\files\\textfile.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter("C:\\NDC\\JavaSnippets\\files\\output.txt"))) {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            System.out.println("All done");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
