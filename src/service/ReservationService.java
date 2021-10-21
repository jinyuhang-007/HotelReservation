package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.Collection;
import java.util.Date;

public class ReservationService {
    private

    public static ReservationService reservationService = null;

    private ReservationService(){}

    public static ReservationService getInstance(){
        if(reservationService == null){
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(Room room){

    }
    public IRoom getARoom(String roomId){

    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

    }
    public Collection<Reservation> getCustomerReservation(Customer customer){

    }
    public void printAllReservation(){

    }
}
