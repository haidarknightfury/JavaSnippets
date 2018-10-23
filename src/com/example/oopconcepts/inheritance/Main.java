package com.example.oopconcepts.inheritance;

public class Main {

    public static void main(String[] args) {

        ExtendedClass extendedClass = new ExtendedClass("Haidar", "Curepipe", 22);

        // Extended/Child class can be converted to BaseClass but not inverse
        BaseClass baseClass = extendedClass;
        System.out.println(baseClass.toString());

        BaseClass anotherBaseClass = new BaseClass("baka", "japan");
        ExtendedClass anotherExtendedClass = (ExtendedClass) anotherBaseClass;
        // class cast exception; cannot be downcasted
        System.out.println(anotherExtendedClass);

    }

}
