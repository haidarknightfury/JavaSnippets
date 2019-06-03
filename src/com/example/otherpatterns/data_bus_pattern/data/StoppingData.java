package com.example.otherpatterns.data_bus_pattern.data;

import java.time.LocalDateTime;

import com.example.otherpatterns.data_bus_pattern.AbstractDataType;
import com.example.otherpatterns.data_bus_pattern.DataType;

public class StoppingData extends AbstractDataType {

    public static DataType of(LocalDateTime when) {
        return new StoppingData(when);
    }

    private final LocalDateTime when;

    public StoppingData(LocalDateTime when) {
        this.when = when;
    }

    public LocalDateTime getWhen() {
        return this.when;
    }

}
