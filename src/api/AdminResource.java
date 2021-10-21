package api;

import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    public static AdminResource adminResource = null;
    private AdminResource(){}
    public static AdminResource getInstance(){
        if(adminResource == null){
            adminResource = new AdminResource();
        }
        return adminResource;
    }
    public Customer getCustomer(String email){}

    public void addRoom(List<IRoom> rooms){}

    public Collection<IRoom> getAllRooms(){}

    public Collection<Customer> getAllCustomers(){}

    public void displayAllReservations(){}
}
