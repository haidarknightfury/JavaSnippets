package com.example.patterns.command_pattern;

public class LightController {

    private Command command;

    public Command getCommand() {
        return this.command;
    }

    public void pressButton() {
        this.command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
