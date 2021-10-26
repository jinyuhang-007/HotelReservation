package model;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        String firstName = scanner.next();
        String lastName = scanner.next();
        Customer customer = new Customer(firstName,lastName,email);
        System.out.println(customer);
    }
}
