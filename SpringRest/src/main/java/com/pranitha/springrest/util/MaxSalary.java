package com.pranitha.springrest.util;

import com.pranitha.springrest.model.Customer;

import java.util.List;

/**
 * Created by naveen on 2/3/16.
 */
public class MaxSalary {


    public Customer getMaxsalary(List<Customer> list){

        double max = list.get(0).getSalary();

        Customer customer = null;
        for(Customer cs : list ){
            if(cs.getSalary() > max){
                customer = cs;
                max = cs.getSalary();
            }

        }
        return customer;


    }

}
