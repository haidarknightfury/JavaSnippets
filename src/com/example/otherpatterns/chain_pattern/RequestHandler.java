package com.example.otherpatterns.chain_pattern;

public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request req) {
        if (this.next != null) {
            this.next.handleRequest(req);
        }
    }

    protected void printHandling(Request req) {
        System.out.println("Handling " + req.toString());
    }

    @Override
    public abstract String toString();

}
