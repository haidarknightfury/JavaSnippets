package com.example.patterns.strategy_pattern.main;

import java.util.HashMap;
import java.util.Map;

import com.example.patterns.strategy_pattern.strategy.CapitalizationStrategy;
import com.example.patterns.strategy_pattern.strategy.ReduceStrategy;
import com.example.patterns.strategy_pattern.strategy.base.BaseStrategy;

public class StrategyManager {

    public enum Strategy {
        CAPITALISE, REDUCE, TRIM
    }

    private Map<Strategy, BaseStrategy<String>> mapStrategy;

    public StrategyManager() {
        this.mapStrategy = new HashMap<StrategyManager.Strategy, BaseStrategy<String>>();
        this.mapStrategy.put(Strategy.CAPITALISE, new CapitalizationStrategy());
        this.mapStrategy.put(Strategy.REDUCE, new ReduceStrategy());
        this.mapStrategy.put(Strategy.TRIM, s -> s.trim());
    }

    public String applyStrategy(Strategy strategy, String value) {
        return this.mapStrategy.get(strategy).convert(value);
    }
}
