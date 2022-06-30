package pl.jkanclerz.payu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.jkanclerz.crm.Client;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate http;

    @Test
    void itAllowsToMakePayment() {
        String url = String.format(
                "http://localhost:%s/api/payment", port);

        OrderCreateRequest request = OrderCreateRequest.builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .description("RTV market")
                .currencyCode("PLN")
                .totalAmount(21000)
                .buyer(Buyer.builder()
                        .email("john.doe@example.com")
                        .phone("654111654")
                        .firstName("John")
                        .lastName("Doe")
                        .language("pl")
                        .build())
                .products(Arrays.asList(
                        Product.builder()
                                .name("Wireless Mouse for Laptop")
                                .unitPrice(15000)
                                .quantity(1)
                                .build()
                ))
                .build();

        ResponseEntity<OrderCreateResponse> response = http.postForEntity(url, request, OrderCreateResponse.class);

        System.out.println(response.getBody().getClass());

        assertEquals(200, response.getStatusCodeValue());
    }
}