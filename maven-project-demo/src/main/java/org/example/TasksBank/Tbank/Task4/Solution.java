package org.example.TasksBank.Tbank.Task4;

/*
Условие:

Во время разработки некоторой задачи Саша решил сгенерировать несколько новых тестов.
Каждый тест Саши должен представлять собой натуральное число, не меньшее l и не большее r.
Кроме того, натуральное число в тесте обязательно должно состоять из одинаковых цифр.
Например, число 999 подходит под это требование, а число 123 — нет.
Какое максимальное число различных тестов сможет создать Саша?
*/

/*
Данные:

1:
4 7
Итог: 4

2:
10 100
Итог: 9

3:
19 88593952893092
Итог: 114
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        System.out.println(solution(l, r));
    }

    public static long solution(long l, long r) {
        long count = 0;

        for (long i = l; i <= r;) {
            long numberLength = String.valueOf(i).length();
            long firstDigit = i / ((long) Math.pow(10L, numberLength-1));

            long m = numberLength-1;
            long resultNumber = firstDigit;
            while (m != 0) {
                resultNumber = (resultNumber * 10L) + firstDigit;
                m--;
            }

            i += (long) Math.pow(10L, numberLength-1);

            if (resultNumber <= r && resultNumber >= l) {
                System.out.println(resultNumber);
                count++;
            }
        }

        return count;
    }
}
