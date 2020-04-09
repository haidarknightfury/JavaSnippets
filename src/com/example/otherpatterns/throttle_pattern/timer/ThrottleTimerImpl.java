package com.example.otherpatterns.throttle_pattern.timer;

import java.util.Timer;
import java.util.TimerTask;

import com.example.otherpatterns.throttle_pattern.CallsCount;

public class ThrottleTimerImpl implements Throttler {

    private final int throttlePeriod;
    private final CallsCount callsCount;

    public ThrottleTimerImpl(int throttlePeriod, CallsCount callsCount) {
        super();
        this.throttlePeriod = throttlePeriod;
        this.callsCount = callsCount;
    }

    @Override
    public void start() {

        new Timer(true).schedule(new TimerTask() {

            @Override
            public void run() {
                ThrottleTimerImpl.this.callsCount.reset();
            }
        }, 0, this.throttlePeriod);
    }

}
