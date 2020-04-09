package com.example.otherpatterns.ambassador_pattern;

import com.example.otherpatterns.ambassador_pattern.util.RandomProvider;

public class RemoteService implements RemoteServiceInterface {

    static final int THRESHOLD = 200;
    private static RemoteService service = null;
    private final RandomProvider randomProvider;

    static synchronized RemoteService getRemoteService() {
        if (service == null) {
            service = new RemoteService();
        }
        return service;
    }

    private RemoteService() {
        this(Math::random);
    }

    public RemoteService(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    @Override
    public long doRemoteFunction(int value) {
        long waitTime = (long) Math.floor(this.randomProvider.random() * 1000);
        try {
            Thread.sleep(waitTime);
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
        return waitTime <= THRESHOLD ? value * 10 : FAILURE;
    }

}
