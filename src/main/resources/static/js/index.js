const getProducts = () => {
    return fetch('/api/products')
        .then(r => r.json());
}
function addToCartV2(productId) {
    fetch('/api/sales/add-to-cart/'.concat(productId), {method: 'POST'}).
    then(r => {
        showNewOffer();
        });
}
function showNewOffer() {
    const cartEl = document.querySelector('.cart');

    getCurrentOffer()
    .then(
        body => {
            refreshOffer(cartEl, body);
        }
    );
}
function buttonAddListener(productId) {
    let btn = document.getElementById(productId);
    btn.addEventListener('click', addToCartV2.bind(null, btn.id));
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
                    <li class="list-group-item"><button id="${product.id}" class="btn btn-primary">Add to cart</button></li>
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
    let total = offer.total.toString();
    let items = offer.itemsCount.toString();

    cartEl.querySelector('.cart__total').textContent = total.concat(" PLN");
    cartEl.querySelector('.cart__itemsCount').textContent = items;
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

        getProducts()
            .then(products => {
                products.forEach(product => buttonAddListener(product.id))
            })
            .catch(e => console.log(e));
})();

