package com.example.snippets.lamda.functional_interface.example1;

public class Main {

    public static String stringConversion(String str, StringUtility util) {
        return util.execute(str);
    }

    public static void main(String[] args) {

        StringUtility capitalise = param -> param.toUpperCase();
        System.out.println(stringConversion("hello", capitalise));

    }
}
