package api;

import model.IRoom;

import java.util.Scanner;

public class AdminMenu {
    public static AdminResource adminResource = AdminResource.getInstance();
    public AdminMenu(){}
    public void printAdminMenu(){
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

                }else if(command=="5"){
                    running = false;
                }
            }catch(Exception exception){

            }
        }
    }
}
