package com.example.otherpatterns.chain_pattern;

public class Root {

    RequestHandler chain;

    public Root() {
        this.buildChain();
    }

    private void buildChain() {
        this.chain = new Level1Handler(new Level2Handler(null));
    }

    public void makeRequest(Request req) {
        this.chain.handleRequest(req);
    }
}
