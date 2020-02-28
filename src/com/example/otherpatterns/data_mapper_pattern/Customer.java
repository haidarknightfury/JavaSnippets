package com.example.otherpatterns.data_mapper_pattern;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    private int customerId;
    private String name;

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* Student id is assumed to be unique */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.customerId;
        result = prime * result + (this.name == null ? 0 : this.name.hashCode());
        return result;
    }

    /* Check if both objects are same */
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
        Customer other = (Customer) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + this.customerId + ", name=" + this.name + "]";
    }

}
