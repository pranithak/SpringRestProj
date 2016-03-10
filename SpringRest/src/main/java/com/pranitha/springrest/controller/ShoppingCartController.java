package com.pranitha.springrest.controller;

import com.pranitha.springrest.model.Customer;
import com.pranitha.springrest.service.CustomerService;
import com.pranitha.springrest.service.CustomerServiceImpl;
import com.pranitha.springrest.util.CustomerAge;
import com.pranitha.springrest.util.MaxSalary;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by naveen on 1/19/16.
 */
@RestController
public class ShoppingCartController {

    private static final Logger logger = Logger.getLogger(ShoppingCartController.class);


    @Resource(name="customerService")
    private CustomerService customerService ;



    //CustomerService customerService ;
    MaxSalary salary;

    CustomerAge customerAge;

    public CustomerAge getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(CustomerAge customerAge) {
        this.customerAge = customerAge;
    }

    public MaxSalary getSalary() {
        return salary;
    }

    public void setSalary(MaxSalary salary) {
        this.salary = salary;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //= new CustomerServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        String message = "This is my spring rest ";
        return new ModelAndView("index", "message",  message);

    }
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView login() {
        String message = "This is my login page ";
        return new ModelAndView("login", "message",  message);

    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public ModelAndView home() {
        String message = "This is my home page ";
        return new ModelAndView("home", "message",  message);

    }


    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Customer>> listAllCustomers() {

        //logs debug message
//        if(logger.isDebugEnabled()){
//            logger.debug("listAllCustomers is executed!");
//        }
//        logger.info("Going to getting list all customers");
//
//
//        //logs exception
//        logger.error("This is Error message", new Exception("Testing"));

        List<Customer> customerList = customerService.findAllCustomers();
        if(customerList.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);// 204   You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/salary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> listAllCustomersSal() {

        List<Customer> customerList = customerService.findAllCustomers();

        Customer customer = salary.getMaxsalary(customerList);
        if(customerList.isEmpty()){
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);// 204   You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/ages/{age}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomersAge(@PathVariable("age") int age) {

        List<Customer> customerList = customerService.findAllCustomers();
        List<Customer> user = customerAge.getCustomersAge(customerList,age);
        if(customerList.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);// 204   You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerId(@PathVariable("id") int id){
        System.out.println("Fetching User with id " + id);
        Customer user = customerService.findById(id);
        if(user == null)
        {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);// 404  You many decide to return HttpStatus.NOT_FOUND

        }
        return new ResponseEntity<Customer>(user, HttpStatus.OK); // 200

    }


//    @RequestMapping(value = "/customers/{name}" , method = RequestMethod.GET)
//    public ResponseEntity<Customer> getCustomerName(@PathVariable("name") String name){
//
//        System.out.println("Fetching User with name " + name);
//
//        Customer user1 = customerService.findByName(name);
//        if(user1 == null){
//            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
//
//        }
//
//        return new ResponseEntity<Customer>(user1, HttpStatus.OK);
//
//    }



    @RequestMapping(value = "/customers" , method = RequestMethod.POST)
    public ResponseEntity<Void> saveCustomer(@RequestBody Customer customer ,  UriComponentsBuilder ucBuilder){
        System.out.println("Creating User " + customer.getName());



        if (customerService.isCustomerExist(customer)) {
            System.out.println("A User with name " + customer.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT); // 409
        }

        customerService.saveCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED); // 201
    }




    @RequestMapping(value = "/customers" , method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteAllCustomers(){

        customerService.deleteAllCustomers();

        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);


    }

    @RequestMapping(value = "/customers/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") int id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Customer>(HttpStatus.OK); // 200

    }


    @RequestMapping(value="/customers/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id , @RequestBody Customer user){

        System.out.println("Updating User " + id);

        Customer currentCustomer = customerService.findById(id);
        if (currentCustomer==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        currentCustomer.setAge(user.getAge());
        currentCustomer.setName(user.getName());
        currentCustomer.setSalary(user.getSalary());

        customerService.updateCustomer(currentCustomer);

        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }



}
