package com.example.ruleengine;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.example.ruleengine.engine.Engine;
import com.example.ruleengine.entity.Fake;
import com.example.ruleengine.rule.BasicRules;

public class Main {

    public static void main(String[] args) {
        List<Fake> fakes = Arrays.asList(new Fake("12", "haidar", "dargaye"), new Fake("12", "haidar", "dargaye"), new Fake("13", "haidar", "dargaye"), new Fake("14", "haidar", "dargaye"));
        // BinaryOperator<Predicate<Fake>> binop = (p, q) -> p.and(q);
        List<Fake> results = new Engine().findByRules(fakes, Arrays.asList(BasicRules.ageIs("12"), BasicRules.FNameStartBy("hai")), Predicate::and);
        System.out.println(results);
    }

}
