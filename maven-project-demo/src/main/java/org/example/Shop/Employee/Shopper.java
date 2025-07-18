package org.example.Shop.Employee;

import org.example.Shop.Exceptions.NoMoneyException;
import org.example.Shop.Exceptions.PersonNotInShopException;
import org.example.Shop.Exceptions.ProductNotInShopException;
import org.example.Shop.People.GenderType;
import org.example.Shop.People.Person;
import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;
import org.example.Shop.Building.Shop;

import java.util.*;

public class Shopper extends Person {
    private int money;
    private Shop shop;
    private boolean isInShop;
    private final Map<Product, Integer> products = new HashMap<>();

    public boolean isInShop() {
        return isInShop;
    }

    public Shop getShop() {
        return shop;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setInShop(boolean inShop) {
        isInShop = inShop;
    }

    public void goToShop(Shop shop) {
        if (isInShop) {
            System.out.println(getName() + " сначала выйди из магазина " + shop.getName());
            return;
        }

        this.shop = shop;
        isInShop = true;
    }

    public void leaveShop() {
        if (!isInShop) {
            throw new PersonNotInShopException(getName() + " и так не в магазине");
        }

        if (!products.isEmpty()) {
            System.out.println(getName() + " сначала заплати за продукты");
            return;
        }

        this.shop = null;
        isInShop = false;
    }

    public void buyProduct(Product product, int countProduct) {
        if (!isInShop) {
            throw new PersonNotInShopException(getName() + " сначала сходи в магазин");
        }

        if (!checkProductInShop(product)) {
            throw new ProductNotInShopException(product.getName() + " нет в магазине " + shop.getName());
        }

        if (countProductInShop(product) < countProduct) {
            System.out.println("В магазине " + shop.getName() + " только " + countProductInShop(product) + " " + product.getName());
            throw new ProductNotInShopException(product.getName() + " в кол-ве " + countProduct + " нет!");
        }

        if ((int) Math.round(product.getPrice()*countProduct) <= money) {
            money -= (int) Math.round(product.getPrice()*countProduct);

            products.computeIfPresent(product, (_, v) -> v + countProduct);
            products.putIfAbsent(product, countProduct);
        } else {
            throw new NoMoneyException(getName() + " нехватает денег для покупки " + product.getName() + " в кол-ве " + countProduct);
        }
    }

    private boolean checkProductInShop(Product product) {
        Map<Product, Integer> shopProducts = shop.getAllProducts();
        return shopProducts.containsKey(product);
    }

    private int countProductInShop(Product product) {
        Map<Product, Integer> shopProducts = shop.getAllProducts();
            for (Product shopProduct : shopProducts.keySet()) {
                if (product.getId() == shopProduct.getId()) {
                    return shopProducts.get(product);
                }
            }

        return 0;
    }

    public void removeProductById(int id) {
        for (Product product: products.keySet()) {
            if (product.getId() == id) {
                money += (int) product.getPrice();
                products.remove(product);
                break;
            }
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void viewListProducts() {
        for (Product product : products.keySet()) {
            System.out.println(product);
        }
    }

    public Map<Product, Integer> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products.keySet()) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public Set<Product> getProductsByType(ProductType type) {
        Set<Product> result = new HashSet<>(products.size());

        for (Product product : products.keySet()) {
            if (product.getType().equals(type)) {
                result.add(product);
            }
        }

        return result;
    }

    public Shopper() {
        super();
    }

    public Shopper(String name) {
        super(name);
    }

    public Shopper(String name, int age) {
        super(name, age);
    }

    public Shopper(String name, GenderType gender) {
        super(name, gender);
    }

    public Shopper(String name, int age, GenderType gender) {
        super(name, age, gender);
    }

    public Shopper(String name, int age, GenderType gender, int money) {
        super(name, age, gender);
        this.money = money;
    }
}
