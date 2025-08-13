package org.example.Tasks.FunctionTasks;

/*
Создайте класс Employee, представляющий сотрудника организации.
В методе main() класса Main создайте список сотрудников.
Данные каждого сотрудника вводятся с новой строки, элементы разделяются пробелами.
Строка "end" означает завершение списка.

На основании списка сотрудников создайте отображение, ключом в котором будет название отдела,
 а значением - сотрудник с наибольшей зарплатой.
Выведите содержимое отображения на консоль так, как показано в примере теста.
Ключи (т.е. отделы) должны быть отсортированы по алфавиту.

Если получается пустой список (сразу пользователь вводит "end"), то на консоль ничего не выводится.

1.
Шевченко бухгалтерия 1200.60
Павлюк цех 1320.99
Анненков бухгалтерия 700.20
Трубинина бухгалтерия 1000.36
Тоцкий цех 925.56
Ермоленко цех 2500.50
end

2.
Звонарева Маг.1 789.99
Пикуль Маг.2 236.16
Шоева Маг.1 634.55
Кравченко Маг.3 789.99
end
*/

/*
1.
бухгалтерия : Шевченко;бухгалтерия;1200.6
цех : Ермоленко;цех;2500.5

2.
Маг.1 : Звонарева;Маг.1;789.99
Маг.2 : Пикуль;Маг.2;236.16
Маг.3 : Кравченко;Маг.3;789.99
*/

import java.util.*;
import java.util.stream.Collectors;

public class MaxBy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        String text;

        while (!(text = scanner.nextLine()).equals("end")) {
            String[] data = text.split(" +");
            employees.add(new Employee(data[0], data[1], Double.parseDouble(data[2])));
        }

        Map<String, Optional<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue().get()));
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ";" + department + ";" + salary;
    }
}