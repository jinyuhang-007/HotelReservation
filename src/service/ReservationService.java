package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    /*
    * 资源：reservation、rooms
    * */
    private Collection<Reservation> reservations = new HashSet<>();
    private Collection<IRoom> rooms = new HashSet<>();

    public static ReservationService reservationService = null;
    private ReservationService(){}
    public static ReservationService getInstance(){
        if(reservationService == null){
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(Room room){
        IRoom newRoom = new Room(room);
        rooms.add(newRoom);
    }
    /*
    * 这样写对吗?
    *
    * */
    public IRoom getARoom(String roomNumber){
        for(IRoom room: rooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        System.out.println("Reservation: We don't have room"+roomNumber+"!");
        return null;
    }

    public Collection<IRoom> getAllRooms(){
        return rooms;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Collection<IRoom> roomSet = findRooms(checkInDate,checkOutDate);
        if(roomSet.contains(room)){
            Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);
            reservations.add(reservation);
            return reservation;
        }
        System.out.println("ReservationService: We're sorry. This room is invalid now!");
        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> result = new HashSet<>(rooms);
        if(reservations.size()==0){
            return result;
        }else{
            for(Reservation reservation: reservations){
                if((reservation.getCheckInDate().before(checkInDate) && reservation.getCheckOutDate().after(checkOutDate))||
                        (reservation.getCheckInDate().after(checkInDate) && reservation.getCheckInDate().before(checkOutDate))||
                        (reservation.getCheckOutDate().after(checkInDate) && reservation.getCheckOutDate().before(checkOutDate))){
                    result.remove(reservation.getRoom());
                }
            }
        }
        return result;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        Collection<Reservation> result = new HashSet<>();
        for(Reservation reservation:reservations){
            if(reservation.getCustomer()==customer){
                result.add(reservation);
            }
        }
        return result;

    }

    public void printAllReservation(){
        for(Reservation reservation:reservations){
            System.out.println(reservation.toString());
        }
    }
}
