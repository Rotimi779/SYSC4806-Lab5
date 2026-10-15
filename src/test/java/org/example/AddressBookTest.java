package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AddressBookTest {

    @Test
    void addBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo = new BuddyInfo("Rotimi","Revalie",101253689);
        addressBook.addBuddy(buddyInfo);
        assertEquals(1,addressBook.getBuddies().size());
    }

    @Test
    void removeBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo = new BuddyInfo("Rotimi","Revalie",101253689);
        BuddyInfo buddy2 = new BuddyInfo("Levi","Revalie",101222222);
        addressBook.addBuddy(buddyInfo);
        addressBook.addBuddy(buddy2);
        addressBook.removeBuddy(buddy2);
        assertEquals(1,addressBook.getBuddies().size());
    }
}