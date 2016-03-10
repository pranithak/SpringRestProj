package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Address;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by naveen on 2/6/16.
 */

@Repository
@Transactional
@Service("addressService")

public class AddressServiceHibernateImpl implements AddressService {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Address findById(int id) {
        return null;
    }

    public void saveAddress(Address address) {

    }

    public Address updateAddress(Address address) {
        return null;
    }

    public void deleteAddressById(int id) {

    }

    public List<Address> findAllAddress() {
        String hql = "select a from address a";
        return getSessionFactory().openSession().createQuery("from Address").list();
    }

    public boolean isAddressExist(Address address) {
        return false;
    }
}
