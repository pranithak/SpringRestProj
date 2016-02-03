package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Customer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by naveen on 2/2/16.
 */

@Repository
public class CustomerServiceHibernateDAOImpl implements CustomerService {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }







    public Customer findById(int id) {

       return null;
    }

    public Customer findByName(String name) {
        return null;
    }

    public void saveCustomer(Customer customer) {

    }

    public Customer updateCustomer(Customer customer) {
        return null;
    }

    public void deleteCustomerById(int id) {

    }

    public List<Customer> findAllCustomers() {
        String hql = "select c from customer c";
        return getSessionFactory().openSession().createQuery("from Customer").list();
        // return (List<Customer>) query.uniqueResult();    }
    }

    public void deleteAllCustomers() {

    }

    public boolean isCustomerExist(Customer customer) {
        return false;
    }
}
