package com.example.patterns.chainofresponsibility.lambda2;

public class ChainBuilder<T> {

    public static <T> ChainBuilder<T> chainBuilder() {
        return new ChainBuilder<>();
    }

    private HandlerImpl<T> first;

    private ChainBuilder() {

    }

    public SuccessorBuilder first(Handler<T> handler) {
        this.first = new HandlerImpl<>(handler);
        return new SuccessorBuilder(this.first);
    }

    public class SuccessorBuilder {

        private HandlerImpl<T> current;

        private SuccessorBuilder(HandlerImpl<T> current) {
            this.current = current;
        }

        public SuccessorBuilder successor(Handler<T> successor) {
            HandlerImpl<T> successorWrapper = new HandlerImpl<>(successor);
            this.current.setSuccessor(successorWrapper);
            this.current = successorWrapper;
            return this;
        }

        public Chain<T> build() {
            return new ChainImpl<T>(ChainBuilder.this.first);
        }
    }

    private static class ChainImpl<T> implements Chain<T> {

        private HandlerImpl<T> first;

        public ChainImpl(HandlerImpl<T> first) {
            this.first = first;
        }

        @Override
        public void handle(T t) {
            this.first.handle(t);
        }

    }

    private static class HandlerImpl<T> implements Handler<T> {

        private final Handler<T> delegate;
        private Handler<T> successor;

        public HandlerImpl(Handler<T> delegate) {
            this.delegate = delegate;
        }

        public void setSuccessor(HandlerImpl<T> successor) {
            this.successor = successor;
        }

        @Override
        public boolean handle(T t) {
            if (this.delegate.handle(t)) {
                return true;
            } else if (this.successor != null) {
                return this.successor.handle(t);
            }
            return false;
        }

    }
}
