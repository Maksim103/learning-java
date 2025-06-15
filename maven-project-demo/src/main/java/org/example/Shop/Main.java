package org.example.Shop;

import org.example.Shop.Building.Shop;
import org.example.Shop.Employee.SecurityGuard;
import org.example.Shop.Employee.Seller;
import org.example.Shop.Employee.Shopper;
import org.example.Shop.People.GenderType;
import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;

public class Main {
    public static void main(String[] args) {
        Shop magnit = new Shop("Магнит", "Краснодар" ,350.5);
        magnit.open();

        Shopper shopper = new Shopper("Maks", 18, GenderType.Man, 8000);
        Seller seller = new Seller(magnit, "Igor", 25, GenderType.Man, 35_000, 10);
        SecurityGuard securityGuard = new SecurityGuard(magnit, "Julia", 34, GenderType.Woman, 25_000, 14);

        Product iphone = new Product(1, "Iphone", 5000, 4, ProductType.ELECTRONICS);
        Product apple = new Product(2, "Apple", 150, 20, ProductType.FOOD);

        magnit.addAllProducts(iphone);
        magnit.addAllProducts(apple);

        shopper.goToShop(magnit);
        System.out.println(shopper.getName() + " в магазине? : " + (shopper.isInShop() ? "Да" : "Нет"));

        shopper.buyProduct(apple, 5);
        shopper.buyProduct(iphone, 1);
        shopper.removeProductById(apple.getId());

        shopper.viewListProducts();
        System.out.println();

        securityGuard.work(13);
        System.out.println(securityGuard.calculateSalary());

        securityGuard.work(2);
        securityGuard.workExtra(5);

        System.out.println(securityGuard.getName() + " поработал ещё дополнительно " + securityGuard.getExtraWorkingHours());
        System.out.println(securityGuard.calculateSalary());
        System.out.println();

        seller.serviceShopper(shopper);
        System.out.println(shopper.getMoney() + " - кол-во денег у " + shopper.getName());

        shopper.leaveShop();
        System.out.println(shopper.getName() + " в магазине? : " + (shopper.isInShop() ? "Да" : "Нет"));
    }
}
