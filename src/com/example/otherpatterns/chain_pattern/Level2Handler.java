package com.example.otherpatterns.chain_pattern;

public class Level2Handler extends RequestHandler {

    public Level2Handler(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(RequestType.LEVEL2)) {
            this.printHandling(request);
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Level2Handler";
    }

}
