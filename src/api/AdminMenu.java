package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.*;

public class AdminMenu {
    public static AdminResource adminResource = AdminResource.getInstance();
    public AdminMenu(){}
    public void printAdminMenu(){
        System.out.println("------AdminMenu-----");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
    }
    public void start(){
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running){
            try{
                this.printAdminMenu();
                int command = scanner.nextInt();
                if(command==1){
                    Collection<Customer> customers = adminResource.getAllCustomers();
                    for(Customer customer: customers){
                        System.out.println(customer);
                    }
                }else if(command==2){
                    Collection<IRoom> rooms = adminResource.getAllRooms();
                    for(IRoom room: rooms){
                        System.out.println(room);
                    }
                }else if(command==3){
                    adminResource.displayAllReservations();
                }else if(command==4){
                    System.out.println("Please enter roomNumber, price, roomType(1.SINGLE 2.DOUBLE) and isFree(true or false)");
                    System.out.println("** Example: '1 100 1 false'");
                    String roomNumber = scanner.next();
                    Double price = scanner.nextDouble();
                    int roomType = scanner.nextInt();
                    boolean isFree = scanner.nextBoolean();
                    if(roomType==1){
                        Room room = new Room(roomNumber, price, RoomType.SINGLE, isFree);
                        adminResource.addRoom(room);
                        System.out.println("Successfully finished!");
                    }else if(roomType==2){
                        Room room = new Room(roomNumber, price, RoomType.DOUBLE, isFree);
                        adminResource.addRoom(room);
                        System.out.println("Successfully finished!");
                    }else{
                        System.out.println("Invalid input!");
                    }
                }else if(command==5){
                    running = false;
                }
            }catch(Exception exception){
                System.out.println("Invalid input!");
                scanner.next();
            }
        }
    }
}
