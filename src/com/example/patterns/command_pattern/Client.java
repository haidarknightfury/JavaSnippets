package com.example.patterns.command_pattern;

public class Client {

    public static void main(String[] args) {
        LightController lightController = new LightController();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        lightController.setCommand(lightOnCommand);
        lightController.pressButton();

        System.out.println(light.getOn());

        lightController.setCommand(lightOffCommand);
        lightController.pressButton();

        System.out.println(light.getOn());

    }
}
