package org.example.Tasks.FunctionTasks;

/*
Подсчитать средний возраст студентов и найти максимальный средний балл.
Вывести результаты через пробел, округлив средний возраст до целого, а максимальный балл - до одного знака.
Если исходный список студентов пуст, то средний возраст должен быть 20, а максимальный балл - 0.0.
С новой строки следует также вывести данные студента с самой длинной фамилией.
А если список студентов пуст - то текст "Empty data".

1.
Иванов;25;8.4
Сидоров;15;6.7
Александров;28;7.5
end
*/

/*
1.
23 8.4
Александров;28;7.5
*/

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class StatisticsStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        String text;

        while (!(text = scanner.nextLine()).equals("end")) {
            String[] data = text.split(";");
            students.add(new Student(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2])));
        }

        OptionalDouble averageAge = students.stream().mapToInt(Student::getAge).average();
        Optional<Student> maxGrade = students.stream().max((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
        Optional<Student> maxNameLength = students.stream().max((s1, s2) -> s1.getName().length() - s2.getName().length());

        System.out.print(Math.round(averageAge.orElse(20)) + " ");
        System.out.println(maxGrade.orElse(new Student("", 0, 0.0)).getAverageGrade());

        if (students.isEmpty()) {
            System.out.println("Empty data");
        } else {
            System.out.println(maxNameLength.get());
        }
    }
}

class Student {
    private String name;
    private int age;
    private double averageGrade;

    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return  name + ";" + age + ";" + averageGrade;
    }
}