package org.example.Shop.Employee;

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

    private final ArrayList<Product> products = new ArrayList<>();

    public boolean isInShop() {
        return isInShop;
    }

    public Shop getShop() {
        return shop;
    }

    public ArrayList<Product> getProducts() {
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
            System.out.println(getName() + " и так не в магазине");
            return;
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
            System.out.println("Сначала надо сходить в магазин");
            return;
        }

        if (!checkProductInShop(product)) {
            System.out.println(product.getName() + " нет в магазине " + shop.getName());
            return;
        }

        if (countProductInShop(product) < countProduct) {
            System.out.println(product.getName() + " в кол-ве " + countProduct + " нет!");
            System.out.println("В магазине " + shop.getName() + " только " + countProductInShop(product) + " " + product.getName());
            return;
        }

        if ((int) Math.round(product.getPrice()*countProduct) <= money) {
            money -= (int) Math.round(product.getPrice()*countProduct);

            for (int i = 0; i < countProduct; i++) {
                products.add(product);
            }
        } else {
            System.out.println(getName() + " нехватает денег для покупки " + product.getName() + " в кол-ве " + countProduct);
        }
    }

    private boolean checkProductInShop(Product product) {
        ArrayList <Product> shopProducts = shop.getAllProducts();
        for (Product shopProduct : shopProducts) {
            if (product.getId() == shopProduct.getId()) {
                return true;
            }
        }

        return false;
    }

    private int countProductInShop(Product product) {
        int count = 0;
        ArrayList <Product> shopProducts = shop.getAllProducts();
            for (Product shopProduct : shopProducts) {
                if (product.getId() == shopProduct.getId()) {
                    count++;
                }
            }

        return count;
    }

    public void removeProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                money += (int) products.get(i).getPrice();
                products.remove(i);
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
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public ArrayList<Product> getProductsByType(ProductType type) {
        ArrayList<Product> result = new ArrayList<>();

        for (Product product : products) {
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
