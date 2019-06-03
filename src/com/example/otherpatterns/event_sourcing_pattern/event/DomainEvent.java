package com.example.otherpatterns.event_sourcing_pattern.event;

import java.io.Serializable;

public abstract class DomainEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long sequenceId;
    private final long createdTime;
    private final String eventClassName;
    private boolean realTime = true;

    public DomainEvent(long sequenceId, long createdTime, String eventClassName) {
        this.sequenceId = sequenceId;
        this.createdTime = createdTime;
        this.eventClassName = eventClassName;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public String getEventClassName() {
        return this.eventClassName;
    }

    public long getSequenceId() {
        return this.sequenceId;
    }

    public boolean isRealTime() {
        return this.realTime;
    }

    /**
     * Abstract method to be implement
     */
    public abstract void process();

    public void setRealTime(boolean realTime) {
        this.realTime = realTime;
    }

}
