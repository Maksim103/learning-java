package org.example.Shop.People;

import org.example.Shop.Building.Shop;
import org.example.Shop.Employee.Seller;
import org.example.Shop.Employee.Shopper;
import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    @Test
    void testCalculateSalary() {
        Shop magnit = new Shop("Magnit", 326.5);
        Seller seller = new Seller(magnit, "Igor", 25, GenderType.Man, 35_000, 10);

        seller.work(5);
        double salary = seller.calculateSalary();

        assertEquals(0, salary);
    }

    @Test
    void testGetExtraWorkingHours() {
        Shop magnit = new Shop("Magnit", "Moscow", 326.5);
        Seller seller = new Seller(magnit, "Igor", 25, GenderType.Man, 35_000, 10);

        seller.work(15);
        seller.workExtra(7);

        assertEquals(12, seller.getExtraWorkingHours());
    }

    @Test
    void testServiceShopper() {
        Shop magnit = new Shop("Magnit", "Moscow", 326.5);
        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 20, ProductType.FOOD);

        magnit.addProducts(iphone);
        magnit.addProducts(apple);

        Shopper shopper = new Shopper("Maks", 18, GenderType.Man, 8000);

        shopper.goToShop(magnit);
        shopper.buyProduct(iphone, 1);
        shopper.buyProduct(apple, 15);

        Seller seller = new Seller(magnit, "Igor", 25, GenderType.Man, 35_000, 10);

        seller.serviceShopper(shopper);

        assertEquals(16, seller.getSalesCount());
        assertEquals(750, shopper.getMoney());
    }

    @Test
    void testWorkExtra() {
        Shop magnit = new Shop("Magnit");
        Seller seller = new Seller(magnit, "Igor", 25, GenderType.Man, 35_000, 10);

        seller.work(5);
        seller.workExtra(4);

        assertEquals(0, seller.getExtraWorkingHours());
    }

    @Test
    void testNewDayWork() {
        Shop magnit = new Shop("Magnit");
        Seller seller = new Seller(magnit, "Igor", 25, GenderType.Man, 35_000, 10);

        seller.newDayWork();
        assertFalse(seller.isWorked());
    }
}