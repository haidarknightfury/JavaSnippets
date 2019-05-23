package com.example.patterns.composite_entity_pattern;

public class CoarseGrainedObject {

    Employee employee = new Employee();
    Manager manager = new Manager();

    public String[] getData() {
        return new String[] { "Employee : " + this.employee.getJobSuccess() + " Manager " + this.manager.getSatisfaction() };
    }

    public void setData(String jobSuccess, String satisfaction) {
        this.employee.setJobSuccess(jobSuccess);
        this.manager.setSatisfaction(satisfaction);
    }
}
