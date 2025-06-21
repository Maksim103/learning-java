package org.example.Shop.Building;

import org.example.Shop.Products.Product;
import org.example.Shop.Products.ProductType;

import java.util.*;

public class Shop implements Building {
    private String name;
    private String address;
    private double area;
    private boolean isOpen;
    private final Map<Product, Integer> products = new HashMap<>();

    {
        isOpen = true;
        name = "No Name";
        address = "No Address";
        area = 0;
    }

    public Map<Product, Integer> getAllProducts() {
        return products;
    }

    public void addAllProducts(Product product) {
        products.putIfAbsent(product, product.getQuantity());
        product.reduceQuantity(product.getQuantity());

        products.computeIfPresent(product, (_, v) -> v + product.getQuantity());
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

    public void removeProductById(int id, int countRemoving) {
        Iterator<Product> iterator = products.keySet().iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                if ((products.get(product) - countRemoving) >= 0) {
                    products.compute(product, (_, v) -> v - countRemoving);
                } else {
                    products.put(product, 0);
                }

                break;
            }
        }
    }

    public void removeAllProductsById(int id) {
        Iterator<Product> iterator = products.keySet().iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public int countProductInShop(Product shopProduct) {
        for (Product product : products.keySet()) {
            if (product.getId() == shopProduct.getId()) {
                return products.get(product);
            }
        }

        return 0;
    }

    public Shop(String name) {
        this.name = name;
    }

    public Shop(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public Shop(String name, String address, double area) {
        this.name = name;
        this.address = address;
        this.area = area;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public void close() {
        isOpen = false;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Double.compare(area, shop.area) == 0 && Objects.equals(name, shop.name) && Objects.equals(address, shop.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, area);
    }
}
