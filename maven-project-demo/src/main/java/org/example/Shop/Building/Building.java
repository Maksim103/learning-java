package org.example.Shop.Building;

public interface Building {
    String getName();
    void setName(String name);

    String getAddress();
    void setAddress(String address);

    double getArea();
    void setArea(double area);

    void open();
    void close();

    boolean isOpen();
}
