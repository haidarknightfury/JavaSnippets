package com.example.otherpatterns.event_sourcing_pattern.domain;

import java.math.BigDecimal;

import com.example.otherpatterns.event_sourcing_pattern.event.AccountCreateEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.MoneyDepositEvent;
import com.example.otherpatterns.event_sourcing_pattern.event.MoneyTransferEvent;
import com.example.otherpatterns.event_sourcing_pattern.state.AccountAggregate;

public class Account {

    private final int accountNo;
    private final String owner;
    private BigDecimal money;

    public Account(int accountNo, String owner, BigDecimal money) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.money = money;
    }

    public Account(int accountNo, String owner) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.money = BigDecimal.ZERO;
    }

    public int getAccountNo() {
        return this.accountNo;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public String getOwner() {
        return this.owner;
    }

    public Account copy() {
        Account account = new Account(this.accountNo, this.owner, this.money);
        return account;
    }

    private void withdraw(BigDecimal money) {
        this.money = this.money.subtract(money);
    }

    private void depositMoney(BigDecimal money) {
        this.money = this.money.add(money);
    }

    private void handleWithdrawal(BigDecimal money, boolean realTime) {
        if (this.money.compareTo(money) == -1) {
            throw new RuntimeException("Insufficient account balance");
        }
        this.withdraw(money);
        AccountAggregate.putAccount(this);
    }

    private void handleDeposit(BigDecimal money, boolean realTime) {
        this.depositMoney(money);
        AccountAggregate.putAccount(this);
        if (realTime) {
            System.out.println("External API Call");
        }
    }

    public void handleEvent(AccountCreateEvent accountCreateEvent) {
        AccountAggregate.putAccount(this);
    }

    public void handleEvent(MoneyDepositEvent moneyDepositEvent) {
        this.handleDeposit(moneyDepositEvent.getMoney(), moneyDepositEvent.isRealTime());
    }

    public void handleTransferFromEvent(MoneyTransferEvent moneyTransferEvent) {
        this.handleWithdrawal(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
    }

    public void handleTransferToEvent(MoneyTransferEvent moneyTransferEvent) {
        this.handleDeposit(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
    }

    @Override
    public String toString() {
        return "Account [accountNo=" + this.accountNo + ", owner=" + this.owner + ", money=" + this.money + "]";
    }

}
