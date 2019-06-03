package com.example.otherpatterns.data_bus_pattern.data;

import com.example.otherpatterns.data_bus_pattern.AbstractDataType;
import com.example.otherpatterns.data_bus_pattern.DataType;

public class MessageData extends AbstractDataType {

    public static DataType of(final String message) {
        return new MessageData(message);
    }

    private final String message;

    public MessageData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
