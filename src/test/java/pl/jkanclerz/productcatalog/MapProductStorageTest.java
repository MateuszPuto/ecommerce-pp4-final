package pl.jkanclerz.productcatalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapProductStorageTest {
    MapProductStorage storage;

    @BeforeEach
    void createStorage() {
        this.storage = new MapProductStorage();
    }

    @Test
    void itSavesProduct() {
        ProductData product = productDataProvider().get(0);
        storage.save(product);

        assertEquals(product.getId(), storage.loadById(product.getId()).getId());
    }

    @Test
    void itSavesMultipleProducts() {
        ArrayList<ProductData> products = productDataProvider();

        for(ProductData product: products){
            product.publish();
            storage.save(product);
        }

        assertEquals(products.size(), storage.allPublishedProducts().size());
    }

    ArrayList<ProductData> productDataProvider() {
        ArrayList<ProductData> products = new ArrayList<ProductData>();

        products.add(new ProductData("15176", "lego set"));
        products.add(new ProductData("18476", "lego set 2"));

        return products;
    }
}