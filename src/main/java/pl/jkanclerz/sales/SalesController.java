package pl.jkanclerz.sales;

import org.springframework.web.bind.annotation.*;
import pl.jkanclerz.sales.cart.Cart;
import pl.jkanclerz.sales.offerting.Offer;
import pl.jkanclerz.sales.payment.PaymentDetails;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class SalesController {

    public static final String CURRENT_CUSTOMER_ID_SESSION_KEY = "CURRENT_CUSTOMER_ID";
    Sales sales;
    private HttpSession httpSession;

    public SalesController(Sales sales, HttpSession httpSession) {
        this.sales = sales;
        this.httpSession = httpSession;
    }

    @GetMapping("/api/sales/current-offer")
    Offer getCurrentOffer() {
        return sales.getCurrentOffer(getCurrentClientId());
    }

    @PostMapping("/api/sales/add-to-cart/{productId}")
    void addToCart(@PathVariable String productId) {
        sales.addToCart(getCurrentClientId(), productId);
    }

    @PostMapping("/api/sales/accept-offer")
    PaymentDetails acceptOffer(@RequestBody CustomerData customerData) {
        return sales.acceptOffer(getCurrentClientId(), customerData);
    }

    @GetMapping("/api/sales/client-id")
    String getClientId() {
        return getCurrentClientId();
    }

    @GetMapping("/api/sales/cart")
    Optional<Cart> getCart() { return sales.getCartDetails(getCurrentClientId()); }

    private String getCurrentClientId() {
        Object customerId = httpSession.getAttribute(CURRENT_CUSTOMER_ID_SESSION_KEY);

        if (customerId == null) {
            customerId = UUID.randomUUID().toString();
            httpSession.setAttribute(CURRENT_CUSTOMER_ID_SESSION_KEY, customerId);
        }

        return (String) customerId;
    }
}
