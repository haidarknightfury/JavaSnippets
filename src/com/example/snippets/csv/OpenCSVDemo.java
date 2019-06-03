package com.example.snippets.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import com.opencsv.CSVReader;

public class OpenCSVDemo {

    static final String csvFile = "C:\\DSOWorkspace\\HAIDAR\\JavaSnippets\\files\\target.txt";

    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            CSVReader csvReader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Stream.of(line).forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
