package com.example.ruleengine.rule;

import java.util.function.Predicate;

import com.example.ruleengine.entity.Fake;

public class BasicRules {

    public static Predicate<Fake> ageIs(String str) {
        return s -> s.getAge().equals(str);
    }

    public static Predicate<Fake> FNameStartBy(String str) {
        return s -> s.getFname().startsWith(str);
    }

    public static Predicate<Fake> SMameStartBy(String str) {
        return s -> s.getSname().startsWith(str);
    }

}
