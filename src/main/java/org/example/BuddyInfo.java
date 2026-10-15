package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    private String name;
    private String address;
    private String email;
    @Id
    private int phoneNumber;

    public BuddyInfo(){
        this.name = "Unknown";
        this.address = "Unknown";
        this.phoneNumber = 0;
    }

    public BuddyInfo(String name, String address, int phoneNumber) {
        if (name == null) {
            this.name = "Default";
        }
        else {
            this.name = name;
        }

        if (address == null) {
            this.address = "Carleton";
        }
        else {
            this.address = address;
        }

        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(String name, String address, int phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String toString(){
        return "BuddyInfo{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phoneNumber= " + phoneNumber + '}';
    }

    public static void main(String[] args) {
        BuddyInfo random = new BuddyInfo("Rotimi","Revalie",101253689);
        System.out.println("Hello World! " + random.getName());
    }
}

