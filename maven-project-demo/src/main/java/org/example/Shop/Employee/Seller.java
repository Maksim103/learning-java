package org.example.Shop.Employee;

import org.example.Shop.Building.Shop;
import org.example.Shop.People.GenderType;
import org.example.Shop.Products.Product;
import java.util.ArrayList;

public class Seller extends EmployeeShop {
    private int salesCount;

    {
        setPosition(PositionType.Seller);
    }

    public Seller(Shop shop, String name, int age, GenderType gender, int salary, int workHours) {
        super(shop, name, age, gender, salary, workHours);
    }

    public void serviceShopper(Shopper shopper) {
        if (!shopper.isInShop() || !shopper.getShop().equals(getShop())) {
            System.out.println(shopper.getName() + " - не в " + getShop().getName());
            return;
        }

        ArrayList<Product> shopperProducts = shopper.getAllProducts();

        while (!shopperProducts.isEmpty()) {
            sellProduct(shopperProducts.getFirst());
            shopperProducts.removeFirst();
        }
    }

    private void sellProduct(Product product) {
        salesCount++;
        getShop().removeProductById(product.getId());

        System.out.println(getName() + " продал " + product.getName() + "! Всего продаж: " + salesCount);
    }

    public int getSalesCount() {
        return salesCount;
    }

    @Override
    public double calculateSalary() {
        if (isWorked()) {
            return getSalary() + getExtraWorkingHours()*50 + (salesCount*5);
        }

        System.out.println(getName() + " ещё не отработал свои часы!");
        return 0;
    }

    @Override
    public void newDayWork() {
        super.newDayWork();
        salesCount = 0;
    }
}
