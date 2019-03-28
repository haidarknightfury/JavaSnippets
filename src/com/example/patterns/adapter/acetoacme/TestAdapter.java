package com.example.patterns.adapter.acetoacme;

public class TestAdapter {

    public static void main(String[] args) {
        Ace ace = new Ace();
        ace.name = "haidar dargaye";

        AceToAcmeAdapter Iacme = new AceToAcmeAdapter(ace);
        AcmeInterface acmeInterface = Iacme;

        System.out.println(Iacme.getFname());
        System.out.println(Iacme.getLname());

    }
}
