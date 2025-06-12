package org.example.Shop.Employee;

public interface Employee {
    int getSalary();
    void setSalary(int salary);
    double calculateSalary();

    void work(int workingHours);
    boolean isWorked();
    void setWorked(boolean worked);
    void newDayWork();

    int getWorkHours();
    void setWorkHours(int workHours);

    PositionType getPosition();
    void setPosition(PositionType position);
}
