package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String email, String firstName, String lastName){
        String emailRegex = "^(.+)@(.+).(.+)$";

        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(email).matches()==false){
            throw new IllegalArgumentException("It is an illegal email address!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
