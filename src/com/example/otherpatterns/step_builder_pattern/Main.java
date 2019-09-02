package com.example.otherpatterns.step_builder_pattern;

public class Main {

    public static void main(String[] args) {

        Person person = PersonStepBuilder.newBuilder().name("Haidar").withUsername("hdargaye").noRoles().build();
        System.out.println(person);

        Person person2 = PersonStepBuilder.newBuilder().name("Haidar").withUsername("hdargaye").withRole("ADMIN").withRole("BOSS").withNoMoreRole().build();
        System.out.println(person2);

    }
}
