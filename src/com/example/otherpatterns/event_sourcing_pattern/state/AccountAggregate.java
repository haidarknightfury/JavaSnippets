package com.example.otherpatterns.event_sourcing_pattern.state;

import java.util.HashMap;
import java.util.Map;

import com.example.otherpatterns.event_sourcing_pattern.domain.Account;

public class AccountAggregate {

    private static Map<Integer, Account> accounts = new HashMap<>();

    public static Account getAccount(int accountNo) {
        return accounts.getOrDefault(accountNo, null);
    }

    public static void putAccount(Account account) {
        accounts.put(account.getAccountNo(), account);
    }

    public static void resetState() {
        accounts = new HashMap<>();
    }

    private AccountAggregate() {
    }

}