package com.example.otherpatterns.data_mapper_pattern;

import java.util.Optional;

public interface CustomerDataMapper {

    Optional<Customer> find(int customerId);

    void insert(Customer customer) throws DataMapperException;

    void update(Customer customer) throws DataMapperException;

    void delete(Customer customer) throws DataMapperException;

}
