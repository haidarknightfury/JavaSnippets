package com.example.snippets.file.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizingText {

    public static void main(String[] args) {

        // Reading text file
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("C:\\NDC\\JavaSnippets\\files\\textfile.txt")))) {
            // default separating token is space " "

            while (s.hasNext()) {
                StringTokenizer tokenizer = new StringTokenizer(s.nextLine(), ",");

                while (tokenizer.hasMoreTokens()) {
                    System.out.println(tokenizer.nextToken());
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
