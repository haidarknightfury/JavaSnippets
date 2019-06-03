package com.example.otherpatterns.data_bus_pattern;

import java.util.function.Consumer;

public interface Member extends Consumer<DataType> {

    @Override
    void accept(DataType event);
}
