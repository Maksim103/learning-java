package org.example.Shop.Employee;

import org.example.Shop.Building.Shop;
import org.example.Shop.Exceptions.PersonNotInShopException;
import org.example.Shop.People.GenderType;
import org.example.Shop.People.Person;

public abstract class EmployeeShop extends Person implements Employee {
    private PositionType position;
    private int salary;
    private int workHours;
    private boolean isWorked;
    private int extraWorkingHours;

    private Shop shop;

    {
        position = PositionType.Indefinite;
        salary = 0;
        workHours = 0;
        isWorked = false;
        extraWorkingHours = 0;
        shop = null;
    }

    public int getExtraWorkingHours() {
        return extraWorkingHours;
    }

    public void resetExtraWorkingHours() {
        extraWorkingHours = 0;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        if (this.shop != null) {
            System.out.println("Сначала надо выйти из магазина");
            return;
        }

        this.shop = shop;
    }

    @Override
    public void setPosition(PositionType position) {
        this.position = position;
    }

    @Override
    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    @Override
    public int getWorkHours() {
        return workHours;
    }

    @Override
    public PositionType getPosition() {
        return position;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public abstract double calculateSalary();

    @Override
    public void newDayWork() {
        setWorked(false);
        resetExtraWorkingHours();
    }

    @Override
    public boolean isWorked() {
        return isWorked;
    }

    @Override
    public void setWorked(boolean worked) {
        isWorked = worked;
    }

    @Override
    public void work(int workingHours) {
        if (workingHours == workHours) {
            System.out.println("Отлично! " + getName() + " отработал свои часы");
            isWorked = true;
        } else if (workingHours < workHours) {
            workHours -= workingHours;
            System.out.println(getName() + " ещё осталось поработать " + workHours);
        } else {
            isWorked = true;
            extraWorkingHours += (workingHours-workHours);
            System.out.println(getName() + " - сверхурочно работает");
        }
    }

    public void workExtra(int extraHours) {
        if (isWorked()) {
            extraWorkingHours += extraHours;
            System.out.println(getName() + " работал ещё " + extraHours + " дополнительно!");
        }
        else {
            work(extraHours);
        }
    }

    public EmployeeShop(Shop shop, String name) {
        super(name);
        this.shop = shop;
    }

    public EmployeeShop(Shop shop, String name, int age) {
        super(name, age);
        this.shop = shop;
    }

    public EmployeeShop(Shop shop, String name, GenderType gender) {
        super(name, gender);
        this.shop = shop;
    }

    public EmployeeShop(Shop shop, String name, int age, GenderType gender) {
        super(name, age, gender);
        this.shop = shop;
    }

    public EmployeeShop(Shop shop, String name, int age, GenderType gender, int salary, int workHours) {
        super(name, age, gender);
        this.shop = shop;
        this.salary = salary;
        this.workHours = workHours;
    }

    public EmployeeShop(Shop shop, String name, int age, GenderType gender, int salary, PositionType position, int workHours) {
        super(name, age, gender);
        this.shop = shop;
        this.salary = salary;
        this.position = position;
        this.workHours = workHours;
    }
}
