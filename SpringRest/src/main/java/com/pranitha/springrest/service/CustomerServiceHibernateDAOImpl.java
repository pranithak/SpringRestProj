package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by naveen on 2/2/16.
 */

@Repository
@Service("customerService")

public class CustomerServiceHibernateDAOImpl implements CustomerService {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Customer findById(int id) {

        //Session session = sessionFactory.getCurrentSession();
        // Retrieve existing person
        // Create a Hibernate query (HQL)
        //Query query = session.createQuery("from Customer where id = "+id);
        return (Customer) getSessionFactory().openSession().createQuery("from Customer where id = "+id).uniqueResult();
        //return (Customer) query.uniqueResult();
    }

    public void saveCustomer(Customer customer) {

//        // Retrieve session from Hibernate
//        Session session = sessionFactory.getCurrentSession();
//
//        // Persists to db
//        session.save(customer);
        getSessionFactory().openSession().save(customer);
    }

    public void deleteCustomerById(int id) {

        System.out.println("deleting id " + id);
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.createQuery("delete Customer where id = "+id);
        session.flush();
        tx.commit();
    //    getSessionFactory().openSession().createQuery("delete Customer where id = "+id);

    }

    public List<Customer> findAllCustomers() {
       // String hql = "select c from customer c";

        return getSessionFactory().openSession().createQuery("from Customer").list();
        // return (List<Customer>) query.uniqueResult();    }
    }

    public void deleteAllCustomers() { }
    public Customer findByName(String name) {
        return null;
    }
    public Customer updateCustomer(Customer customer) {
        return null;
    }
    public boolean isCustomerExist(Customer customer) {
        return false;
    }
}
