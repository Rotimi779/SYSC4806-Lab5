package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {

    @Test
    void getName() {
        BuddyInfo random = new BuddyInfo("Rotimi","Revalie",101253689);
        assertEquals("Rotimi", random.getName());
    }

    @Test
    void getAddress() {
        BuddyInfo random = new BuddyInfo("Rotimi","Revalie",101253689);
        assertEquals("Revalie", random.getAddress());
    }

    @Test
    void getPhoneNumber() {
        BuddyInfo random = new BuddyInfo("Rotimi","Revalie",101253689);
        assertEquals(101253689, random.getPhoneNumber());
    }
}