package org.example.Shop.Employee;

import org.example.Shop.Building.Shop;
import org.example.Shop.Exceptions.NotWorkHoursException;
import org.example.Shop.Exceptions.PersonNotInShopException;
import org.example.Shop.People.GenderType;
import org.example.Shop.Products.Product;
import java.util.Iterator;
import java.util.Map;

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

        Map<Product, Integer> shopperProducts = shopper.getAllProducts();
        Iterator<Map.Entry<Product, Integer>> iterator = shopperProducts.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> entry = iterator.next();
            Product product = entry.getKey();
            Integer countProduct = entry.getValue();

            sellProduct(product, countProduct);
            iterator.remove();
        }
    }

    private void sellProduct(Product product, int countProduct) {
        salesCount += countProduct;
        getShop().removeProductById(product.getId(), countProduct);

        System.out.println(getName() + " продал " + product.getName() + " " +
                "в кол-ве " + countProduct + " шт.! Всего продаж: " + salesCount);
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
