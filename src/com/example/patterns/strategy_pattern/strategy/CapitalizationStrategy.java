package com.example.patterns.strategy_pattern.strategy;

import com.example.patterns.strategy_pattern.strategy.base.BaseStrategy;

public class CapitalizationStrategy implements BaseStrategy<String> {

    @Override
    public String convert(String param) {
        return param.toUpperCase();
    }

}
