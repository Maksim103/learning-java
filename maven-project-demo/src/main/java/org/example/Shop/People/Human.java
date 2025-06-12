package org.example.Shop.People;

public interface Human {
    void setName(String name);
    String getName();

    void setAge(int age);
    int getAge();

    void setGender(GenderType gender);
    GenderType getGender();
}
