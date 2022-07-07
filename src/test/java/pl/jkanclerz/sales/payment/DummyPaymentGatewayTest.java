package pl.jkanclerz.sales.payment;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DummyPaymentGatewayTest {

    @Test
    void itMakesPayment() {
        RegisterPaymentRequest request = new RegisterPaymentRequest("345", BigDecimal.ONE, "mateusz", "zaba", "mail@d.com");
        DummyPaymentGateway gateway = new DummyPaymentGateway();

        RegisterPaymentResponse response = gateway.register(request);

        assertEquals("paymentId__123qwe", response.getPaymentId());
        assertEquals("http://dumyyPaymentGateway", response.getPaymentUrl());
    }
}