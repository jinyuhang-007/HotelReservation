package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static HotelResource hotelResource = null;
    /*
    * final
    * 1. 修饰方法时表示该方法无法被子类改写
    * 2. 修饰变量时表示
    * 3. 修饰类时表示该类无法被继续继承
    * */
    public static final ReservationService reservationService = ReservationService.getInstance();

    private HotelResource(){}

    public static HotelResource getInstance(){
        if(hotelResource==null){
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    public Customer getCustomer(String email){

    }

    public void createACustomer(String email,String firstName,String lastName){

    }

    public IRoom getRoom(String roomNumber){

    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){

    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){

    }

}
