package com.example.otherpatterns.event_sourcing_pattern.event;

import java.math.BigDecimal;
import java.util.Objects;

import com.example.otherpatterns.event_sourcing_pattern.domain.Account;
import com.example.otherpatterns.event_sourcing_pattern.state.AccountAggregate;

public class MoneyTransferEvent extends DomainEvent {

    private static final long serialVersionUID = 1L;

    private BigDecimal money;
    private final int accountNoFrom;
    private final int accountNoTo;

    public MoneyTransferEvent(long sequenceId, long createdTime, BigDecimal money, int accountNoFrom, int accountNoTo) {
        super(sequenceId, createdTime, "MoneyTransferEvent");
        this.money = money;
        this.accountNoFrom = accountNoFrom;
        this.accountNoTo = accountNoTo;
    }

    @Override
    public void process() {
        Account accountFrom = AccountAggregate.getAccount(this.accountNoFrom);
        Objects.requireNonNull(accountFrom, "account from not found");
        Account accountTo = AccountAggregate.getAccount(this.accountNoTo);
        Objects.requireNonNull(accountTo, "account to not found");
        accountFrom.handleTransferFromEvent(this);
        accountTo.handleTransferToEvent(this);

    }

    public int getAccountNoFrom() {
        return this.accountNoFrom;
    }

    public int getAccountNoTo() {
        return this.accountNoTo;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

}
