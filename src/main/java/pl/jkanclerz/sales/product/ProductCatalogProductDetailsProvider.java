package pl.jkanclerz.sales.product;

import pl.jkanclerz.productcatalog.ProductCatalog;
import pl.jkanclerz.productcatalog.ProductData;

import java.util.Optional;

public class ProductCatalogProductDetailsProvider implements ProductDetailsProvider{
    ProductCatalog productCatalog;

    public ProductCatalogProductDetailsProvider(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public Optional<ProductDetails> getById(String productId) {
        ProductData data = productCatalog.findById(productId);

        if (data == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(new ProductDetails(productId, data.getName(), data.getPrice()));
    }
}
