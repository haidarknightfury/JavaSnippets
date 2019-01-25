package com.example.snippets.threading.executor_service_mid;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableSum implements Callable<Long> {

    private List<Integer> list;
    private Integer start, end;

    public CallableSum(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        Long result = 0L;
        for (int i = this.start; i <= this.end; i++) {
            result += this.list.get(i);
        }
        return result;
    }

}
