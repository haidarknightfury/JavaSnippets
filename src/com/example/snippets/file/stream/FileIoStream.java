package com.example.snippets.file.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIoStream {

    // FileInputStream - use binary data

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("C:\\NDC\\JavaSnippets\\files\\textfile.txt");
                FileOutputStream out = new FileOutputStream("C:\\NDC\\JavaSnippets\\files\\output.txt")) {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (Exception e) {
            // FOF exception||IOException
            System.out.println(e.getMessage());
        }

        writePNGFileToAnother();
    }

    public static void writePNGFileToAnother() {
        // Can be used to write png files as well to another
        try (FileInputStream in = new FileInputStream("C:\\NDC\\JavaSnippets\\files\\tulips.jpg");
                FileOutputStream out = new FileOutputStream("C:\\NDC\\JavaSnippets\\files\\tulipsout.jpg")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (Exception e) {
            // FOF exception||IOException
            System.out.println(e.getMessage());
        }
    }
}
