package org.example.AlgorithmsAndStructures.AlgorithmicTasks;

/*
Условие:

У Кати насыщенный день на работе. Ей надо передать n разных договоров коллегам.
Все встречи происходят на разных этажах, а между этажами можно перемещаться только по лестничным пролетам
 — считается, что это улучшает физическую форму сотрудников. Прохождение каждого пролета занимает ровно 1 минуту.
Сейчас Катя на парковочном этаже, планирует свой маршрут.
Коллег можно посетить в любом порядке, но один из них покинет офис через t минут.
С парковочного этажа лестницы нет — только лифт, на котором можно подняться на любой этаж.
В итоге план Кати следующий:

1. Подняться на лифте на произвольный этаж. Считается, что лифт поднимается на любой этаж за t минут.
2. Передать всем коллегам договоры, перемещаясь между этажами по лестнице. Считается, что договоры на этаже передаются мгновенно.
3. В первые t минут передать договор тому коллеге, который планирует уйти.
4. Пройти минимальное количество лестничных пролетов.

Помогите Кате выполнить все пункты ее плана.
*/

/*
Данные:

1:
100 10 12 15
Итог: 160

2:
100 10 12 1
Итог: 100
*/

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] floorEmployees = new int[n];
        for (int i = 0; i < n; i++) {
            floorEmployees[i] = scanner.nextInt();
        }
        int indexEmployee = scanner.nextInt()-1;

        System.out.println(solution(n, t, floorEmployees, indexEmployee));
    }

    public static int solution(int n, int t, int[] floorEmployees, int indexEmployee) {
        int countFlightsStairs = 0;
        boolean flag = false;
        for (int i = 0; i < indexEmployee; i++) {
            countFlightsStairs += (floorEmployees[i+1] - floorEmployees[i]);
        }

        if (countFlightsStairs > t) {
            flag = true;
            countFlightsStairs = floorEmployees[indexEmployee] - floorEmployees[0];
            floorEmployees[indexEmployee] = floorEmployees[indexEmployee-1];
        }

        if (flag) {
            for (int i = 0; i < floorEmployees.length-1; i++) {
                countFlightsStairs += (floorEmployees[i+1] - floorEmployees[i]);
            }
        } else {
            for (int i = indexEmployee; i < floorEmployees.length-1; i++) {
                countFlightsStairs += (floorEmployees[i+1] - floorEmployees[i]);
            }
        }

        return countFlightsStairs;
    }
}
