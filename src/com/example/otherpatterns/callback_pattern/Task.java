package com.example.otherpatterns.callback_pattern;

public abstract class Task {

    protected abstract void execute();

    public final void executeWith(Callback callback) {
        this.execute();
        if (callback != null) {
            callback.call();
        }
    }

}
