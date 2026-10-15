package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;



@Entity
public class AddressBook  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new LinkedList<>();
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null)
        {
            buddies.add(buddy);
        }
    }

    public List<BuddyInfo> getBuddies(){
        return this.buddies;
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public static void main(String[] args) {
        System.out.println("Address Book");
        BuddyInfo buddy = new BuddyInfo("Rotimi","Revalie",101253689);
        BuddyInfo buddy2 = new BuddyInfo("Levi","Revalie",101222222);
        AddressBook addressBook1 = new AddressBook();
        addressBook1.addBuddy(buddy);
        addressBook1.addBuddy(buddy2);
        for(BuddyInfo b: addressBook1.getBuddies()){
            System.out.println("The buddy's name is " + b.getName() + ", the address is " +  b.getAddress() + " and the phone number is " + b.getPhoneNumber());
        }



    }
}

