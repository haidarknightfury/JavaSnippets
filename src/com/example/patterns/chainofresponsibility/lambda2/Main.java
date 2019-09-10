package com.example.patterns.chainofresponsibility.lambda2;

public class Main {

    public static void main(String[] args) {
        ChainBuilder<MyRequest> chainBuilder = ChainBuilder.chainBuilder();
        Chain<MyRequest> chain = chainBuilder.first(request ->
            {
                if (request.getAmount() < 100) {
                    System.out.println("First level handled : " + request.getAmount());
                    return true;
                }
                return false;
            }).successor(request ->
                {
                    if (request.getAmount() < 500) {
                        System.out.println("Second level handled : " + request.getAmount());
                        return true;
                    }
                    return false;
                }).successor(request ->
                    {
                        if (request.getAmount() < 1000) {
                            System.out.println("Third level handled : " + request.getAmount());
                            return true;
                        }
                        return false;
                    }).build();
        chain.handle(new MyRequest(200));

    }

    private static class MyRequest {
        private final double amount;

        private MyRequest(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return this.amount;
        }
    }
}
