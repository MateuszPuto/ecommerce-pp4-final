function contact() {
    let email = document.getElementById("emailInput").value;
    let textArea = document.getElementById("inquiry").value;

    const data = {"id": "123", "email": email, "inquiry": textArea};

    console.log(JSON.stringify(data));

    fetch('http://localhost:8181/api/clients', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
    .then(response => {
        console.log(response);
    });

}