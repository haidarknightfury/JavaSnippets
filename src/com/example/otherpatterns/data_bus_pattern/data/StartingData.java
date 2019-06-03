package com.example.otherpatterns.data_bus_pattern.data;

import java.time.LocalDateTime;

import com.example.otherpatterns.data_bus_pattern.AbstractDataType;
import com.example.otherpatterns.data_bus_pattern.DataType;

public class StartingData extends AbstractDataType {

    public static DataType of(final LocalDateTime when) {
        return new StartingData(when);
    }

    private final LocalDateTime when;

    public StartingData(LocalDateTime when) {
        this.when = when;
    }

    public LocalDateTime getWhen() {
        return when;
    }
}
