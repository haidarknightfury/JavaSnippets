package com.example.otherpatterns.chain_pattern;

public class Level1Handler extends RequestHandler {

    public Level1Handler(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.LEVEL1)) {
            this.printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Level1Handler";
    }

}
