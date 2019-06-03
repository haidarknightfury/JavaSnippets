package com.example.otherpatterns.data_bus_pattern.members;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.otherpatterns.data_bus_pattern.DataType;
import com.example.otherpatterns.data_bus_pattern.Member;
import com.example.otherpatterns.data_bus_pattern.data.MessageData;

public class MessageCollectorMember implements Member {

    private final String name;
    private List<String> messages = new ArrayList<>();

    public MessageCollectorMember(String name) {
        this.name = name;
    }

    @Override
    public void accept(DataType data) {
        if (data instanceof MessageData) {
            this.handleEvent((MessageData) data);
        }
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }

    private void handleEvent(MessageData data) {
        System.out.println(this.name + " : " + data.getMessage());
        this.messages.add(data.getMessage());
    }

}
