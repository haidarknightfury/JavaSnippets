package com.example.snippets.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        CSVReader csvReader = new CSVReader();
        csvReader.read("C:\\DSOWorkspace\\HAIDAR\\JavaSnippets\\files\\target.txt");
    }

    final String SEPARATOR = ",";

    String line = "";

    public void read(String path) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((this.line = br.readLine()) != null) {
                System.out.println(this.line);
                String output[] = this.line.split(this.SEPARATOR);
            }
        }
    }

}
