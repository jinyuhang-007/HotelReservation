package api;

import model.IRoom;
import model.Reservation;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static final HotelResource hotelResource = HotelResource.getInstance();
    public MainMenu(){}
    public void printMainMenu(){
        System.out.println("---------MainMenu---------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. exit");
    }
    public void start(){
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running){
            try{
                this.printMainMenu();
                String command = scanner.next();
                if(command=="1"){
                    System.out.println("please enter your email, checkInDate and checkOutDate:");
                    String customerEmail = scanner.next();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date checkInDate = simpleDateFormat.parse(scanner.next());
                    Date checkOutDate = simpleDateFormat.parse(scanner.next());
                    Collection<IRoom> rooms = hotelResource.findARoom(checkInDate, checkOutDate);
                    System.out.println("which one do you prefer?");
                    for(IRoom room: rooms){
                        System.out.println(room);
                    }
                    System.out.println("Enter the room number:");
                    String roomNumber = scanner.next();
                    IRoom room = hotelResource.getRoom(roomNumber);
                    hotelResource.bookARoom(customerEmail, room, checkInDate, checkOutDate);
                    System.out.println("Successfully booked a room!");
                }else if(command=="2"){
                    System.out.println("Please enter your email:");
                    String customerEmail = scanner.next();
                    Collection<Reservation> reservations = hotelResource.getCustomersReservations(customerEmail);
                    for(Reservation reservation: reservations){
                        System.out.println(reservation);
                    }
                }else if(command=="3"){
                    System.out.println("Please enter your email, firstName and lastName");
                    String customerEmail = scanner.next();
                    String firstName = scanner.next();
                    String lastName = scanner.next();
                    hotelResource.createACustomer(customerEmail, firstName, lastName);
                    System.out.println("Successfully created an account!");
                }else if(command=="4"){
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.start();
                }else if(command=="5"){
                    System.out.println("Thanks for using JYH Hotel Reserving System!");
                    running = false;
                }
            }catch(Exception exception){
                exception.getLocalizedMessage();
            }
        }
    }

}
