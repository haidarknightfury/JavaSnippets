package com.example.otherpatterns.data_mapper_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerMapperImpl implements CustomerDataMapper {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Optional<Customer> find(int customerId) {

        for (final Customer customer : this.customers) {
            if (customer.getCustomerId() == customerId) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public void insert(Customer customer) throws DataMapperException {
        if (!this.customers.contains(customer)) {
            this.customers.add(customer);
        } else {
            throw new DataMapperException("Customer already exists");
        }
    }

    @Override
    public void update(Customer customer) throws DataMapperException {
        if (this.customers.contains(customer)) {
            final int index = this.customers.indexOf(customer);
            this.customers.set(index, customer);
        } else {
            throw new DataMapperException("Customer not exists");
        }
    }

    @Override
    public void delete(Customer customer) throws DataMapperException {
        if (this.customers.contains(customer)) {
            this.customers.remove(customer);
        } else {
            throw new DataMapperException("Customer not exists");
        }

    }

}
