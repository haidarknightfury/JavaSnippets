package com.example.snippets.threading.spliterator;

import java.util.Spliterator;
import java.util.concurrent.Callable;

public class UtilityCallable implements Callable<String> {

    private String results = "";

    private Spliterator<Utility> spliterator;

    public UtilityCallable(Spliterator<Utility> spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public String call() throws Exception {

        if (this.spliterator != null) {
            this.spliterator.forEachRemaining(t ->
                {
                    this.results += t.getName().charAt(0);
                });
            return this.results;
        }
        return null;
    }

}
