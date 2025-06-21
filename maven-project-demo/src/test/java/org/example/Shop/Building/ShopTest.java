package org.example.Shop.Building;

import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testGetAllProducts() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addAllProducts(iphone);
        magnit.addAllProducts(apple);

        assertEquals(2, magnit.getAllProducts().size());
        assertTrue(magnit.getAllProducts().containsKey(iphone));
    }

    @Test
    void testGetProductById() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addAllProducts(iphone);
        magnit.addAllProducts(apple);

        assertEquals(iphone, magnit.getProductById(1));
        assertEquals(apple, magnit.getProductById(2));
    }

    @Test
    void testGetProductsByType() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);
        Product egg = new Product(3, "Egg", 250, 14, ProductType.FOOD);

        magnit.addAllProducts(iphone);
        magnit.addAllProducts(apple);
        magnit.addAllProducts(egg);

        Set<Product> productsShop = magnit.getProductsByType(ProductType.FOOD);
        assertEquals(2, productsShop.size());
    }

    @Test
    void testRemoveProductById() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addAllProducts(iphone);
        magnit.addAllProducts(apple);

        magnit.removeProductById(2, 5);

        assertEquals(2, magnit.getAllProducts().size());
        assertEquals(2, magnit.countProductInShop(apple));
        assertEquals(0, magnit.getProductById(1).getQuantity());
    }

    @Test
    void testRemoveAllProductsById() {
        Shop magnit = new Shop("Magnit", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 7, ProductType.FOOD);

        magnit.addAllProducts(iphone);
        magnit.addAllProducts(apple);

        magnit.removeAllProductsById(2);

        assertEquals(1, magnit.getAllProducts().size());
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