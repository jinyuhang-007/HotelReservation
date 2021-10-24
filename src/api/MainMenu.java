package api;

import java.util.Scanner;

public class MainMenu {
    public static final HotelResource hotelResource = HotelResource.getInstance();
    public MainMenu(){}
    public void printMainMenu(){
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
                    //hotelResource.findARoom();
                }else if(command=="2"){
                    //hotelResource.getCustomersReservations()
                }else if(command=="3"){
                    //hotelResource.createACustomer();
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
