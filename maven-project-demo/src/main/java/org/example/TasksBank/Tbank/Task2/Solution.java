package org.example.TasksBank.Tbank.Task2;

/*
Условие:

Костя подключен к мобильному оператору «Мобайл».
Абонентская плата Кости составляет A рублей в месяц.
За эту стоимость Костя получает B мегабайт интернет-трафика.
Если Костя выйдет за лимит трафика, то каждый следующий мегабайт будет стоить ему C рублей.
Костя планирует потратить  мегабайт интернет-трафика в следующий месяц.
Помогите ему сосчитать, во сколько рублей ему обойдется интернет.
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

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        System.out.println(solution(A, B, C, D));
    }

    public static int solution(int A, int B, int C, int D) {
        int diff = D - B;
        if (diff <= 0) {
            return A;
        } else {
            return diff * C + A;
        }
    }
}
