package com.example.snippets.threading.thread_local_2;

public class BusinessService {

    public void businessMethod() {
        Context context = MyThreadLocal.get();
        System.out.println("Executing Method : " + context.getTransactionId());
    }

}
