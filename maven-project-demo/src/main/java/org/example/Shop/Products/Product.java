package org.example.Shop.Products;

import java.util.Objects;

public class Product {
    private final int id;
    private String name;
    private ProductType type;
    private double price;
    private int quantity;

    public void reduceQuantity() {
        if (quantity > 0 ) {
            quantity--;
        } else {
            System.out.println("Недостаточно товара на складе!");
        }
    }

    public int getId() {
        return id;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public ProductType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(int id, String name, double price, int quantity, ProductType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        Product product = (Product) obj;
        return (id == product.id) && (Double.compare(product.price, price) == 0) && (type.equals(product.type))
                && (name.toLowerCase().equalsIgnoreCase(product.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, type, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
