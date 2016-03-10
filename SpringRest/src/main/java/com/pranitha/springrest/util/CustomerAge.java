package com.pranitha.springrest.util;

import com.pranitha.springrest.model.Customer;


import com.pranitha.springrest.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naveen on 2/3/16.
 */
public class CustomerAge {

    public List<Customer>  getCustomersAge(List<Customer> list , int age){

        List<Customer> customersAge = new ArrayList<Customer>();

        for(Customer cs : list){
            if(age < cs.getAge()){

                customersAge.add(cs);
                    }
        }

        return customersAge;
    }


}
