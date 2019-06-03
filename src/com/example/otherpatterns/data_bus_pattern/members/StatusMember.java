package com.example.otherpatterns.data_bus_pattern.members;

import java.time.LocalDateTime;

import com.example.otherpatterns.data_bus_pattern.DataType;
import com.example.otherpatterns.data_bus_pattern.Member;
import com.example.otherpatterns.data_bus_pattern.data.MessageData;
import com.example.otherpatterns.data_bus_pattern.data.StartingData;
import com.example.otherpatterns.data_bus_pattern.data.StoppingData;

public class StatusMember implements Member {

    private final int id;
    private LocalDateTime started;
    private LocalDateTime stopped;

    public StatusMember(int id) {
        this.id = id;
    }

    @Override
    public void accept(DataType data) {
        if (data instanceof StartingData) {
            this.handleEvent((StartingData) data);
        } else if (data instanceof StoppingData) {
            this.handleEvent((StoppingData) data);
        }
    }

    public LocalDateTime getStarted() {
        return this.started;
    }

    public LocalDateTime getStopped() {
        return this.stopped;
    }

    private void handleEvent(StartingData data) {
        this.started = data.getWhen();
        System.out.println(this.id + " HANDLING EVENT : " + this.started);
    }

    private void handleEvent(StoppingData data) {
        this.stopped = data.getWhen();
        System.out.println(this.stopped);
        data.getDataBus().publish(MessageData.of("Goodbye cruel world : " + this.id));
    }

}
