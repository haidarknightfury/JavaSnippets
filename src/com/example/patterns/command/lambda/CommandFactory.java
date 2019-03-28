package com.example.patterns.command.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {

    @FunctionalInterface
    public interface Command {
        public void execute();
    }

    class Lamp {
        public void turnOff() {
            System.out.println("Lamp turned off");
        }

        public void turnOn() {
            System.out.println("Lamp turn on");
        }
    }

    public static void main(String[] args) {

        CommandFactory commandFactory = new CommandFactory();
        CommandFactory.Lamp lamp = commandFactory.new Lamp();
        commandFactory.add("TURN_ON", lamp::turnOn);
        commandFactory.add("TURN_OFF", lamp::turnOff);
        commandFactory.storeAndExecute("TURN_ON");
        commandFactory.storeAndExecute("TURN_OFF");
        commandFactory.storeAndExecute("TURN_ON");
        commandFactory.storeAndExecute("TURN_OFF");
        commandFactory.history();

    }

    private final Map<String, Command> commands = new HashMap<String, CommandFactory.Command>();

    private List<String> history = new ArrayList<String>();

    public void add(String commandName, Command command) {
        this.commands.put(commandName, command);
    }

    public void history() {
        System.out.println(this.history);
    }

    public void storeAndExecute(String command) {
        Optional.ofNullable(this.commands.get(command)).ifPresent(com ->
            {
                com.execute();
                this.history.add(command);
            });
    }

}
