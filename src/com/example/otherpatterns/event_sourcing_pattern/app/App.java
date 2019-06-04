package com.example.otherpatterns.event_sourcing_pattern.app;

import java.math.BigDecimal;
import java.util.Date;

import com.example.otherpatterns.event_sourcing_pattern.event.AccountCreateEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.MoneyDepositEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.MoneyTransferEvent;
import com.example.otherpatterns.event_sourcing_pattern.processor.DomainEventProcessor;
import com.example.otherpatterns.event_sourcing_pattern.state.AccountAggregate;

public class App {

    public static void main(String[] args) {
        DomainEventProcessor domainEventProcessor = new DomainEventProcessor();
        domainEventProcessor.reset();

        domainEventProcessor.process(new AccountCreateEvent(0, new Date().getTime(), 1, "Dany"));
        domainEventProcessor.process(new AccountCreateEvent(1, new Date().getTime(), 0, "Jon"));

        domainEventProcessor.process(new MoneyDepositEvent(2, new Date().getTime(), 1, BigDecimal.valueOf(100000)));
        domainEventProcessor.process(new MoneyDepositEvent(3, new Date().getTime(), 0, BigDecimal.valueOf(100)));

        domainEventProcessor.process(new MoneyTransferEvent(4, new Date().getTime(), BigDecimal.valueOf(100), 1, 0));

        System.out.println(AccountAggregate.getAccount(1).toString());
        System.out.println(AccountAggregate.getAccount(0).toString());

        AccountAggregate.resetState();

        domainEventProcessor = new DomainEventProcessor();
        domainEventProcessor.recover();

        System.out.println(AccountAggregate.getAccount(1).toString());
        System.out.println(AccountAggregate.getAccount(0).toString());

    }

}
