package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

@SpringBootTest
public class AddressBookIntegrationTest {
    private RestTestClient client;

    @BeforeEach
    void setUp(@Autowired WebApplicationContext context){
        client = RestTestClient.bindToApplicationContext(context).build();
    }

    @Test
    void getBuddiesReturnsOk(){
        client.get().uri("/buddies").exchange().expectStatus().isOk();
    }

    @Test
    void createBuddyReturnsCreated() {
        String buddyJson = """
                {
                    "name": "Rotimi",
                    "address": "Revalie",
                    "phoneNumber": 101253689,
                    "email": "rotimi@gmail.com"
                }
                """;

        client.post()
                .uri("/buddies")
                .contentType(MediaType.APPLICATION_JSON)
                .body(buddyJson)
                .exchange()
                .expectStatus().isCreated();

        client.get()
                .uri("/buddies/101253689")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.email").isEqualTo("rotimi@gmail.com");
    }

    @Test
    void createAddressBookReturnsCreated(){
        String addressBookJson = """
                {}
                """;

        client.post()
                .uri("/addressbooks")
                .contentType(MediaType.APPLICATION_JSON)
                .body(addressBookJson)
                .exchange()
                .expectStatus().isCreated();
    }
}
