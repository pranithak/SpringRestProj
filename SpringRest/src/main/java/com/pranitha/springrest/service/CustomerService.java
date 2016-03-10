package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Customer;

import java.util.List;

/**
 * Created by naveen on 1/19/16.
 */
public interface CustomerService {

    Customer findById(int id);

    Customer findByName(String name);

    void saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomerById(int id);

    List<Customer> findAllCustomers();

    void deleteAllCustomers();

    public boolean isCustomerExist(Customer customer);

    // Customer customerAddresses(int id);


}
