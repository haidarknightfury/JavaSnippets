package com.example.snippets.threading.thread_local_2;

public class Context {

    private String transactionId = null;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
