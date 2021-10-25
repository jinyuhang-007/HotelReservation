package api;

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
                String command = scanner.next();
                if(command=="1"){
                    adminResource.getAllCustomers();
                }else if(command=="2"){
                    adminResource.getAllRooms();
                }else if(command=="3"){
                    adminResource.displayAllReservations();
                }else if(command=="4"){
                    Boolean addRoom = true;
                    List<IRoom> rooms = new ArrayList<IRoom>();
                    while(addRoom){
                        System.out.println("Do you want to continue? (y/n)");
                        String answer = scanner.next();
                        if(answer=="n"){
                            addRoom = false;
                            continue;
                        }
                        System.out.println("Please enter roomNumber, price, roomType(1. SINGLE 2.DOUBLE) and isFree");
                        String roomNumber = scanner.next();
                        Double price = scanner.nextDouble();
                        String roomType = scanner.next();
                        Boolean isFree = scanner.nextBoolean();
                        if(roomType=="1"){
                            IRoom room = new Room(roomNumber, price, RoomType.SINGLE, isFree);
                            rooms.add(room);
                        }else if(roomType=="2"){
                            IRoom room = new Room(roomNumber, price, RoomType.DOUBLE, isFree);
                            rooms.add(room);
                        }
                    }
                    adminResource.addRoom(rooms);
                    System.out.println("Successfully added rooms!");
                }else if(command=="5"){
                    running = false;
                }
            }catch(Exception exception){

            }
        }
    }
}
