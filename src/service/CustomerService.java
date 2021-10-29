package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    /*
    * String: email address
    * */
    private static Collection<Customer> customers = new HashSet<>();

    public static CustomerService customerService = null;

    private CustomerService(){}

    public static CustomerService getInstance(){
        if(customerService==null){
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(email,firstName,lastName);
        customers.add(customer);
    }

    public Customer getCustomer(String customerEmail){
        for(Customer customer: customers){
            if(customer.getEmail().equals(customerEmail)){
                return customer;
            }
        }
        System.out.println("CustomerService: We don't have a customer with this email: "+customerEmail+"!");
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return customers;
    }

}
