package com.example.otherpatterns.event_sourcing_pattern.event;

import java.math.BigDecimal;

import com.example.otherpatterns.event_sourcing_pattern.domain.Account;
import com.example.otherpatterns.event_sourcing_pattern.state.AccountAggregate;

public class MoneyDepositEvent extends DomainEvent {

    private static final long serialVersionUID = 1L;
    private int accountNo;
    private BigDecimal money;

    public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, BigDecimal money) {
        super(sequenceId, createdTime, "MoneyDepositEvent");
        this.accountNo = accountNo;
        this.money = money;
    }

    @Override
    public void process() {
        Account account = AccountAggregate.getAccount(this.accountNo);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        account.handleEvent(this);
    }

    public BigDecimal getMoney() {
        return this.money;
    }

}
