package com.example.otherpatterns.event_sourcing_pattern.event;

import com.example.otherpatterns.event_sourcing_pattern.domain.Account;
import com.example.otherpatterns.event_sourcing_pattern.state.AccountAggregate;

public class AccountCreateEvent extends DomainEvent {

    private static final long serialVersionUID = 1L;
    private int accountNo;
    private String owner;

    public AccountCreateEvent(long sequenceId, long createdTime, int accountNo, String owner) {
        super(sequenceId, createdTime, "AccountCreateEvent");
        this.setAccountNo(accountNo);
        this.setOwner(owner);
    }

    @Override
    public void process() {
        Account account = AccountAggregate.getAccount(this.accountNo);
        if (account != null) {
            throw new RuntimeException("Account already exists");
        }
        account = new Account(this.accountNo, this.owner);
        account.handleEvent(this);
    }

    public int getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
