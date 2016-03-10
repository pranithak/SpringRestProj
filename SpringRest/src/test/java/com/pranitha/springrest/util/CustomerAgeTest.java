package com.pranitha.springrest.util;

import com.pranitha.springrest.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by naveen on 2/6/16.
 */
public class CustomerAgeTest {

    List<Customer> customerList;

    @Before
    public void setUp() throws Exception {

        customerList = new ArrayList<Customer>();
        Customer customer1 = new Customer(1,"john",20,30000);
        Customer customer2 = new Customer(2,"johnny",30,35000);
        Customer customer3 = new Customer(3,"jim",25,30068);
        Customer customer4 =new Customer(4,"jake",22,70000);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);


    }


    @Test
    public void testGetCustomersAge() throws Exception {

        CustomerAge customerAge = new CustomerAge();
       List<Customer> c = customerAge.getCustomersAge(customerList,21);
        assertNotNull(customerAge);
        assertEquals("customer size didnot match",3,c.size());

    }

    @After
    public void tearDown() throws Exception {

    }
}