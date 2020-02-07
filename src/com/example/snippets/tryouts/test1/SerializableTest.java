package com.example.snippets.tryouts.test1;

import java.io.Serializable;

public class SerializableTest implements Serializable {

    private String prop1 = "1234";
    private String prop2 = "5678";

    @Override
    public String toString() {
        return "SerializableTest [prop1=" + this.prop1 + ", prop2=" + this.prop2 + "]";
    }

    public static void main(String[] args) {
        SerializableTest serializableTest = new SerializableTest();
        System.out.println(serializableTest);
    }

}
