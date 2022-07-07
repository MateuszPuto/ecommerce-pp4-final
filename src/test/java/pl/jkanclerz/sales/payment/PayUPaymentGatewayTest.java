package pl.jkanclerz.sales.payment;

import org.junit.jupiter.api.Test;
import pl.jkanclerz.payu.PayU;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PayUPaymentGatewayTest {

    @Test
    void itMakesPayment() {
        RegisterPaymentRequest request = new RegisterPaymentRequest("345", BigDecimal.ONE, "mateusz", "zaba", "mail@d.com");
        PayUPaymentGateway gateway = new PayUPaymentGateway(new PayU("300746"));

        RegisterPaymentResponse response = gateway.register(request);

        assertEquals(RegisterPaymentResponse.class, response.getClass());
    }

}