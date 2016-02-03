package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Customer;
import com.pranitha.springrest.service.CustomerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by naveen on 1/19/16.
 */
public class CustomerServiceImpl implements CustomerService {


    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    private static final AtomicInteger counter = new AtomicInteger();

    private static List<Customer> customersList;

    static{
        customersList= populateDummyCustomers();
    }


//    public int getCustomerCount(){
//
//        String sql="select count(*) from customer";
//
//        return jdbcTemplate.queryForObject(sql,Integer.class);
//
//
//    }

    public Customer findById(int id) {
//        for(Customer customer: customersList){
//            if(customer.getId() == id){
//                return customer;
//            }
//        }
//        return null;

        String sql="select * from customer where id=?";

        return jdbcTemplate.queryForObject(sql,new Object[]{id},new CustomerMapper());

    }


    public static final class CustomerMapper implements RowMapper<Customer> {


        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setAge(resultSet.getInt("age"));
            customer.setSalary(resultSet.getDouble("salary"));
            return customer;
        }
    }

    public Customer findByName(String name) {
        for(Customer customer : customersList){
            if(customer.getName() == name){
                return customer;
            }
        }
        return null;
    }

    public void saveCustomer(Customer customer) {

        System.out.println(customer);

        //customer.setId(counter.incrementAndGet());
        String sql = "insert into customer(id,name,age,salary) values(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{customer.getId(), customer.getName(), customer.getAge(), customer.getSalary()});

        //customersList.add(customer);

    }

    public Customer updateCustomer(Customer customer) {

      //  int index = customersList.indexOf(customer);
        String sql = "update customer SET name = ? where id = ?";
         jdbcTemplate.update(sql,new Object[]{customer.getName() ,customer.getId()});
        return customer;

    }

    public void deleteCustomerById(int id) {

        String sql = "delete from customer where id = ? ";
        jdbcTemplate.update(sql, new Object[]{id});

    }

    public List<Customer> findAllCustomers() {

        String sql = "select * from customer";
        return jdbcTemplate.query(sql,new CustomerMapper());
    }

    public void deleteAllCustomers() {
        customersList.clear();


    }

    public boolean isCustomerExist(Customer customer) {
        return false;
    }


    private static List<Customer> populateDummyCustomers(){
        List<Customer> users = new ArrayList<Customer>();
        users.add(new Customer(counter.incrementAndGet(),"Sam",30, 70000));
        users.add(new Customer(counter.incrementAndGet(),"kim",20, 90000));
        users.add(new Customer(counter.incrementAndGet(),"lary",40, 60000));
        users.add(new Customer(counter.incrementAndGet(),"smith",36, 40000));
        users.add(new Customer(counter.incrementAndGet(),"tom",45, 90000));

        return users;
    }

}
