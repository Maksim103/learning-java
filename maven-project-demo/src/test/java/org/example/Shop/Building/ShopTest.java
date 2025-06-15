package org.example.Shop.Building;

import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testGetAllProducts() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        assertEquals(11, magnit.getAllProducts().size());
        assertTrue(magnit.getAllProducts().contains(iphone));
    }

    @Test
    void testGetProductById() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        assertEquals(iphone, magnit.getProductById(1));
        assertEquals(apple, magnit.getProductById(2));
    }

    @Test
    void testGetProductsByType() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        Object[] product = new Object[apple.getQuantity()];
        for (int i = 0; i < apple.getQuantity(); i++) {
            product[i] = apple;
        }

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        Object[] productsShop = magnit.getProductsByType(ProductType.FOOD).toArray();

        assertEquals(Arrays.toString(productsShop), Arrays.toString(product));
    }

    @Test
    void testRemoveProductById() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        magnit.removeProductById(1);

        assertEquals(10, magnit.getAllProducts().size());
        assertEquals(3, magnit.countProductInShop(iphone));
    }

    @Test
    void testRemoveAllProductsById() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        magnit.removeAllProductsById(2);

        assertEquals(4, magnit.getAllProducts().size());
        assertEquals(0, magnit.countProductInShop(apple));
    }

    @Test
    void testEquals() {
        Shop magnit = new Shop("Magnit", 326.5);
        Shop pyterochka = new Shop("Pyterochka", 326.5);

        assertNotEquals(magnit, pyterochka);
    }

    @Test
    void testHashCode() {
        Shop magnit = new Shop("Magnit", 326.5);
        Shop pyterochka = new Shop("Pyterochka", 326.5);

        assertNotEquals(magnit.hashCode(), pyterochka.hashCode());
    }
}