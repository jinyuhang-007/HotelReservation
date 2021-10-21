package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {
    public static CustomerService customerService = null;

    private CustomerService(){}

    public static CustomerService getInstance(){
        if(customerService==null){
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName){

    }

    public Customer getCustomer(String customerEmail){

    }

    public Collection<Customer> getAllCustomers(){

    }

}
