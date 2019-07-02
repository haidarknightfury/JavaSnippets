package com.example.otherpatterns.collection_pipeline_pattern;

public class Car {

    private final String make;
    private final String model;
    private final int year;
    private final Category category;

    public Car(String make, String model, int year, Category category) {
        super();
        this.make = make;
        this.model = model;
        this.year = year;
        this.category = category;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.category == null ? 0 : this.category.hashCode());
        result = prime * result + (this.make == null ? 0 : this.make.hashCode());
        result = prime * result + (this.model == null ? 0 : this.model.hashCode());
        result = prime * result + this.year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        if (this.category != other.category) {
            return false;
        }
        if (this.make == null) {
            if (other.make != null) {
                return false;
            }
        } else if (!this.make.equals(other.make)) {
            return false;
        }
        if (this.model == null) {
            if (other.model != null) {
                return false;
            }
        } else if (!this.model.equals(other.model)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car [make=" + this.make + ", model=" + this.model + ", year=" + this.year + ", category=" + this.category + "]";
    }

}
