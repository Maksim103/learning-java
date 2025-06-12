package org.example.Shop.Products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testReduceQuantity() {
        Product product = new Product(1, "Apple", 20.0, 5, ProductType.FOOD);
        product.reduceQuantity();

        assertEquals(4, product.getQuantity());
    }

    @Test
    void testProductType() {
        Product product = new Product(1, "Laptop", 1500.0, 5, ProductType.ELECTRONICS);
        assertEquals(ProductType.ELECTRONICS, product.getType());
    }

    @Test
    void testEqualsProducts() {
        Product p1 = new Product(1, "Laptop", 1500.0, 10, ProductType.ELECTRONICS);
        Product p2 = new Product(1, "Laptop", 1500.0, 10, ProductType.CLOTHING);

        assertNotEquals(p1, p2);
    }

}