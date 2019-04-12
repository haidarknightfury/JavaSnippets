package com.example.patterns.business_delegate_pattern;

public class BusinessDelegate {

    private BusinessLookup lookupService = new BusinessLookup();
    private BusinessService businessService;
    private String type;

    public void process() {
        this.businessService = this.lookupService.getBusinessService(this.type);
        this.businessService.process();
    }

    public void setType(String type) {
        this.type = type;
    }

}
