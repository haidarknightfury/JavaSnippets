package com.example.otherpatterns.ambassador_pattern;

public class Client {

    private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

    long useService(int value) {
        long result = this.serviceAmbassador.doRemoteFunction(value);
        System.out.println(String.format("Result is %d ", result));
        return result;
    }
}
