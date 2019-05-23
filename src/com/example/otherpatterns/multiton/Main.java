package com.example.otherpatterns.multiton;

public class Main {

    public static void main(String[] args) {
        Service service = Service.getInstance(ServiceCode.Locker);
        System.out.println(service.getServiceCode());
    }

}
