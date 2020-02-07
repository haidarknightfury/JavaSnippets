package com.example.otherpatterns.ambassador_pattern;

public interface RemoteServiceInterface {

    int FAILURE = -1;

    long doRemoteFunction(int value) throws Exception;
}
