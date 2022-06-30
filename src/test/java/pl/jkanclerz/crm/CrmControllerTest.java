package pl.jkanclerz.crm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrmControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate http;

    @Test
    void itAddsAndGetsClient() {
        String url = String.format(
                "http://localhost:%s/api/clients", port);

        http.put(url, new Client("345", "email@addr.pl"));
        ResponseEntity<Client[]> client = http.getForEntity(url, Client[].class);

        assertEquals(HttpStatus.OK, client.getStatusCode());
    }

}
