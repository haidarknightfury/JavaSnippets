package com.example.ruleengine.engine;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.ruleengine.entity.Fake;

public class Engine {

    public List<Fake> findByRules(List<Fake> fakes, List<Predicate<Fake>> rules, BinaryOperator<Predicate<Fake>> combiner) {
        Predicate<Fake> reducedPredicate = rules.stream().reduce(s -> true, combiner);
        return fakes.stream().filter(reducedPredicate).collect(Collectors.toList());
    }

}
