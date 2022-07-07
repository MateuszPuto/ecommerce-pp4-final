(() => {
    fetch('/api/sales/cart')
    .then(r => r.json())
    .then(data => {
        let t = data;
        let paragraph = document.getElementById("payment-details");
        paragraph.innerHTML = JSON.stringify(t);
    });
})();
function makePayment() {
    let buyer = {
                                           "email": "john.doe@example.com",
                                           "phone": "654111654",
                                           "firstName": "John",
                                           "lastName": "Doe",
                                           "language": "pl"
    };

    let products = [
                        {
                                       "name": "Wireless Mouse for Laptop",
                                       "unitPrice": "15000",
                                       "quantity": "1"
                        },


                        {
                                       "name": "HDMI cable",
                                       "unitPrice": "6000",
                                       "quantity": "1"
                        }
                   ]


    let data = {
                               "notifyUrl": "https://your.eshop.com/notify",
                               "customerIp": "127.0.0.1",
                               "merchantPosId": "300746",
                               "description": "RTV market",
                               "currencyCode": "PLN",
                               "totalAmount": "21000",
                               "buyer": buyer,
                               "products": products
    }

    fetch('http://localhost:8181/api/payment', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer d9a4536e-62ba-4f60-8017-6053211d3f47'
      },
      body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        console.log(data["redirectUri"]);

        window.location.href = data["redirectUri"];
    });
}