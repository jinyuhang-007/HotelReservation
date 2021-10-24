package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    public static AdminResource adminResource = null;
    public static ReservationService reservationService = ReservationService.getInstance();
    public static CustomerService customerService = CustomerService.getInstance();

    private AdminResource(){}
    public static AdminResource getInstance(){
        if(adminResource == null){
            adminResource = new AdminResource();
        }
        return adminResource;
    }
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for(int i=0; i<rooms.size(); i++){
            Room room = (Room)rooms.get(i);
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms(){
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservation();
    }
}
