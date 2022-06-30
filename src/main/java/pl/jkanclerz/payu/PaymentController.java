package pl.jkanclerz.payu;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @CrossOrigin
    @PostMapping("/api/payment")
    OrderCreateResponse makePayment(@RequestBody OrderCreateRequest request) {
        PayU gateway = new PayU("300746");

        OrderCreateResponse response = gateway.handle(request);

        return response;
    }
}
