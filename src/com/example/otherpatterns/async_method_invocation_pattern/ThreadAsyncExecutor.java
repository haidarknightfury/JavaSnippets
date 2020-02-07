package com.example.otherpatterns.async_method_invocation_pattern;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAsyncExecutor implements AsyncExecutor {

    private final AtomicInteger idx = new AtomicInteger(0);

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return this.startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
        CompleteableResult<T> result = new CompleteableResult<>(callback);
        Thread thread = new Thread(() ->
            {
                try {
                    result.setValue(task.call());
                } catch (Exception exception) {
                    result.setException(exception);
                }
            }, "executor-" + this.idx.incrementAndGet());
        thread.start();
        return result;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
        if (!asyncResult.isCompleted()) {
            asyncResult.await();
        }
        return asyncResult.getValue();
    }

    private static class CompleteableResult<T> implements AsyncResult<T> {

        static final int RUNNING = 1;
        static final int FAILED = 2;
        static final int COMPLETED = 3;

        final Object lock;
        final Optional<AsyncCallback<T>> callback;

        volatile int state = this.RUNNING;
        T value;
        Exception exception;

        public CompleteableResult(AsyncCallback<T> asyncCallback) {
            this.lock = new Object();
            this.callback = Optional.ofNullable(asyncCallback);
        }

        void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(exception)));
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        }

        void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;
            this.callback.ifPresent(ac -> ac.onComplete(value, Optional.empty()));
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        }

        @Override
        public boolean isCompleted() {
            return this.state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (this.state == COMPLETED) {
                return this.value;
            } else if (this.state == FAILED) {
                throw new ExecutionException(this.exception);
            } else {
                throw new IllegalStateException("Execution is not completed yet");
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (this.lock) {
                while (!this.isCompleted()) {
                    this.lock.wait();
                }
            }
        }

    }

}
