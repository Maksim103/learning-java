package org.example.Shop.People;

public abstract class Person implements Human {
    private String name;
    private GenderType gender;
    private int age;

    {
        name = "No Name";
        gender = GenderType.Indefinite;
        age = 0;
    }

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, GenderType gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person(String name, int age, GenderType gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }
}
