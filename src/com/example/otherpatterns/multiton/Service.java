package com.example.otherpatterns.multiton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Service {

    private static Map<ServiceCode, Service> services;

    static {
        services = new ConcurrentHashMap<>();
        services.put(ServiceCode.Locker, new Service(ServiceCode.Locker));
        services.put(ServiceCode.Storage, new Service(ServiceCode.Storage));
    }

    public static Service getInstance(ServiceCode serviceCode) {
        return services.get(serviceCode);
    }

    private ServiceCode serviceCode;

    public Service(ServiceCode serviceCode) {
        this.setServiceCode(serviceCode);
    }

    public ServiceCode getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

}
