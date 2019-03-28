package com.example.patterns.command;

public class Light {

    private Boolean on;

    public Boolean getOn() {
        return this.on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public void switchOff() {
        this.on = false;
    }

    public void switchOn() {
        this.on = true;
    }
}
