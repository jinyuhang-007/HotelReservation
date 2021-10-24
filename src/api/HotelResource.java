package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class HotelResource {
    public static HotelResource hotelResource = null;
    /*
    * final
    * 1. 修饰方法时表示该方法无法被子类改写
    * 2. 修饰对象时表示修饰该对象的引用不能改变
    * 3. 修饰类时表示该类无法被继续继承
    * */
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static final CustomerService customerService = CustomerService.getInstance();

    private HotelResource(){}

    public static HotelResource getInstance(){
        if(hotelResource==null){
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email,String firstName,String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        if(customerService.getCustomer(customerEmail)==null) {
            return null;
        }else{
            Customer customer = customerService.getCustomer(customerEmail);
            return reservationService.reserveARoom(customer, room, checkInDate,checkOutDate);
        }

    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.getCustomerReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }

}
