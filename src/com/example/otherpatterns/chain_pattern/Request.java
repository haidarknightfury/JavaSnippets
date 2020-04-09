package com.example.otherpatterns.chain_pattern;

public class Request {

    private final RequestType requestType;

    private final String requestDescription;

    private boolean handled;

    public Request(final RequestType requestType, final String requestDescription) {
        this.requestType = requestType;
        this.requestDescription = requestDescription;
    }

    public String getRequestDescription() {
        return this.requestDescription;
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }

    @Override
    public String toString() {
        return "Request [requestType=" + this.requestType + ", requestDescription=" + this.requestDescription + ", handled=" + this.handled + "]";
    }

}
