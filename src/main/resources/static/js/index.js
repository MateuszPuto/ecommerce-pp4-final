//productRelates
const getProducts = () => {
    return fetch('/api/products')
        .then(r => r.json());
}
function addToCart(price) {
    let total = document.getElementsByClassName("cart__total")[0];
    let amount = total.getInnerHTML();

    let itemsCount = document.getElementsByClassName("cart__itemsCount")[0];
    let itemsAmount = itemsCount.getInnerHTML();

    let cartPrice = parseInt(amount.substring(0, amount.length - 4)) + price;

    let items = parseInt(itemsAmount) + 1;

    total.innerHTML = cartPrice.toString() + " PLN";
    itemsCount.innerHTML = items.toString();
}
const createProductHtmlElement = (product) => {
    const template = `
        <li>
        <div class="card" style="width: 18rem;">
            <h4 class="card-title">${product.name}</h4>
            <img class="card-img-top" src="${product.imageUrl}"/>
            <p class="card-text">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><span>Price: ${product.price} zł</span></li>
                    <li class="list-group-item"><button data-product-id="${product.id}" class="btn btn-primary" onclick="addToCart(${product.price})">Add to cart</button></li>
                </ul>
            </p>
        </div>
        </li>
    `;

    return createHtmlElementFromString(template);
}
const createHtmlElementFromString = (htmlTemplate) => {
    const parentEl = document.createElement('div');
    parentEl.innerHTML = htmlTemplate.trim();

    return parentEl.firstChild;
}
//salesRelated
const getCurrentOffer = () => {
    return fetch('/api/sales/current-offer')
            .then(r => r.json());
}
const refreshOffer = (cartEl, offer) => {
    cartEl.querySelector('.cart__total').textContent = `${offer.total} PLN`;
    cartEl.querySelector('.cart__itemsCount').textContent = `${offer.itemsCount}`;
}
//MAIN
(() => {
    const cartEl = document.querySelector('.cart');
    getCurrentOffer()
        .then(offer => refreshOffer(cartEl, offer));

    const productListEl = document.querySelector('.products__list');
        getProducts()
            .then(products => {
                products
                    .map(product => createProductHtmlElement(product))
                    .forEach(productHtml => {
                        productListEl.appendChild(productHtml);
                    });
            })
            .catch(e => console.log(e));
})();

