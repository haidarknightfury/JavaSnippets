package com.example.snippets.reflection.person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Haidar");
        try {
            Field field = person.getClass().getDeclaredField("name"); // getDeclared is for non inherited members
            // Inherited fields => getField
            field.setAccessible(true);// overriding private
            System.out.println(field.get(person));// non static - need instance

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Field field = Person.class.getDeclaredField("number");
            field.setAccessible(true);
            System.out.println(field.get(null));

        } catch (Exception e) {
        }

        try {
            // get methods
            Method method = person.getClass().getDeclaredMethod("getName");
            System.out.println(method.invoke(person));

            Method setterMethod = person.getClass().getDeclaredMethod("setName", String.class);
            setterMethod.invoke(person, "Huss");
            System.out.println(person.getName());

            Method staticMethod = Person.class.getDeclaredMethod("printPerson", Person.class);
            staticMethod.invoke(null, person);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
