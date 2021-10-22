package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    /*
    * String: email address
    * */
    private static Map<String, Customer> customers;

    public static CustomerService customerService = null;

    private CustomerService(){}

    public static CustomerService getInstance(){
        if(customerService==null){
            customerService = new CustomerService();
            customers = new HashMap<String, Customer>();
        }
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(email,firstName,lastName);
        customers.put(customer.getEmail(), customer);
    }

    public Customer getCustomer(String customerEmail){
        if(customers.containsKey(customerEmail)){
            return customers.get(customerEmail);
        }else{
            System.out.println("CustomerService: This customer doesn't exist!");
            return null;
        }
    }

    public Collection<Customer> getAllCustomers(){
        Collection<Customer> resultSet = new HashSet<Customer>();
        for(Map.Entry<String, Customer> entry:customers.entrySet()){
            resultSet.add(entry.getValue());
        }
        return resultSet;
    }

}
