package com.example.otherpatterns.data_bus_pattern;

import java.time.LocalDateTime;

import com.example.otherpatterns.data_bus_pattern.data.MessageData;
import com.example.otherpatterns.data_bus_pattern.data.StartingData;
import com.example.otherpatterns.data_bus_pattern.data.StoppingData;
import com.example.otherpatterns.data_bus_pattern.members.MessageCollectorMember;
import com.example.otherpatterns.data_bus_pattern.members.StatusMember;

public class Main {

    public static void main(String[] args) {

        final DataBus bus = DataBus.getInstance();
        bus.subscribe(new StatusMember(1));
        bus.subscribe(new StatusMember(2));

        final MessageCollectorMember firstMsgCollector = new MessageCollectorMember("first");
        final MessageCollectorMember secondMsgCollector = new MessageCollectorMember("second");

        bus.subscribe(firstMsgCollector);
        bus.subscribe(secondMsgCollector);

        bus.publish(MessageData.of("Hello world"));
        bus.unsubscribe(firstMsgCollector);
        bus.publish(MessageData.of("Hello world"));

        bus.publish(StartingData.of(LocalDateTime.now()));
        bus.publish(StoppingData.of(LocalDateTime.now()));

    }

}
