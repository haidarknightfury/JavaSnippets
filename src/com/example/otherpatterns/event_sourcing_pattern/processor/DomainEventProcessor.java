package com.example.otherpatterns.event_sourcing_pattern.processor;

import com.example.otherpatterns.event_sourcing_pattern.event.DomainEvent;

public class DomainEventProcessor {

    private final JsonFileJournal processorJournal = new JsonFileJournal();

    public void process(DomainEvent domainEvent) {
        domainEvent.process();
        this.processorJournal.write(domainEvent);
    }

    public void reset() {
        this.processorJournal.reset();
    }

    public void recover() {
        DomainEvent domainEvent;
        while (true) {
            domainEvent = this.processorJournal.readNext();
            if (domainEvent == null) {
                break;
            } else {
                domainEvent.process();
            }
        }
    }

}
