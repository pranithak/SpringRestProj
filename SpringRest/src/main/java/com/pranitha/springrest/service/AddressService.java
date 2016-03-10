package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Address;

import java.util.List;

/**
 * Created by naveen on 2/4/16.
 */
public interface AddressService {

    Address findById(int id);


    void saveAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddressById(int id);

    List<Address> findAllAddress();

    public boolean isAddressExist(Address address);



}
