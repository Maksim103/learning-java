package org.example.Shop.People;

import org.example.Shop.Building.Shop;
import org.example.Shop.Employee.Shopper;
import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopperTest {

    @Test
    void testBuyProduct() {
        Shop magnit = new Shop("Magnit");
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 20, ProductType.FOOD);

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        Shopper shopper = new Shopper("Maks", 18, GenderType.Man, 8000);

        shopper.goToShop(magnit);
        shopper.buyProduct(iphone, 1);
        shopper.buyProduct(apple, 15);

        assertEquals(iphone, shopper.getProductById(1));
        assertEquals(750, shopper.getMoney());
    }

    @Test
    void testSetMoney() {
        Shopper shopper = new Shopper("Maks", 18, GenderType.Man, 6000);
        shopper.setMoney(5000);

        assertEquals(5000, shopper.getMoney());
    }
}