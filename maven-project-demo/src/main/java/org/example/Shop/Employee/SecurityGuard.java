package org.example.Shop.Employee;

import org.example.Shop.Building.Shop;
import org.example.Shop.Exceptions.NotWorkHoursException;
import org.example.Shop.People.GenderType;

public class SecurityGuard extends EmployeeShop {
    {
        setPosition(PositionType.SecurityGuard);
    }

    public SecurityGuard(Shop shop, String name, int age, GenderType gender, int salary, int workHours) {
        super(shop, name, age, gender, salary, workHours);
    }

    @Override
    public double calculateSalary() {
        if (isWorked()) {
            return getSalary() + getExtraWorkingHours()*100;
        }

        throw new NotWorkHoursException(getName() + " ещё не отработал свои часы");
    }
}
