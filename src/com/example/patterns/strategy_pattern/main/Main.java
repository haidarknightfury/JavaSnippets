package com.example.patterns.strategy_pattern.main;

import com.example.patterns.strategy_pattern.main.StrategyManager.Strategy;

public class Main {
    public static void main(String[] args) {
        StrategyManager strategyManager = new StrategyManager();
        System.out.println(strategyManager.applyStrategy(Strategy.CAPITALISE, "haidar"));
    }
}
