package com.example.krakathon.easy;

import java.util.ArrayList;
import java.util.List;

public class Decrypt {

    public static final String START = "A";
    public static final String END = "Z";

    public static void main(String[] args) {
        String phrase = "WIMGSOAENPT NEBNEACVTRZENAALTUL QICDXOBOUKJLNTEJ";

        for (int i = 1; i <= 26; i++) {
            System.out.println("RESULT: " + decrypt(phrase, i));
        }

    }

    public static String decrypt(String str, int offset) {
        int ascA = START.toCharArray()[0];
        int ascZ = END.toCharArray()[0];
        int space = " ".toCharArray()[0];

        List<Integer> decryptedResults = new ArrayList<>();

        str.chars().forEach(ch -> {
            int newOffset = ch + offset;
            if (ch == space) {
                decryptedResults.add(ch);
            } else if (newOffset > ascZ) {
                newOffset = ascA + (ch + offset) - ascZ - 1;
                decryptedResults.add(newOffset);
            } else {
                decryptedResults.add(newOffset);
            }
        });

        StringBuilder result = new StringBuilder();
        decryptedResults.forEach(ch -> {
            char chr = (char) ch.intValue();
            result.append(String.valueOf(chr));
        });
        return result.toString();

    }

}
