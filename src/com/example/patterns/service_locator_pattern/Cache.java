package com.example.patterns.service_locator_pattern;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<Service> services;

    public Cache() {
        this.services = new ArrayList<>();
    }

    public void addService(Service service) {
        Service fService = this.getService(service.getServiceName());
        if (fService == null) {
            this.services.add(service);
        }
    }

    public Service getService(String serviceName) {
        return this.services.stream().filter(serv -> serv.getServiceName().equalsIgnoreCase(serviceName)).findFirst().orElse(null);
    }

}
