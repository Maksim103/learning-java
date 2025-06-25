package org.example.TasksBank.Tbank.Task5;

/*
Условие:

Даня в обеденный перерыв ходит в одно и то же кафе.
Ему, как сотруднику банка, положено специальное предложение: при каждой покупке больше, чем на 100 рублей,
 Даня получает купон на бесплатный обед.

Даня узнал стоимость своих обедов на ближайшие n дней.
Ему хочется минимизировать свои затраты, грамотно используя талоны.
 Требуется найти минимальные суммарные затраты Дани на обеды.
*/

/*
Данные:
1:

12
35
40
101
59
63
201
300
79
5
23
15
51
Итог:

*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int sumResult = 0;
        int coupons = 0;
        int maxPriceIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (coupons > 0) {
                for (int j = i; j < numbers.length; j++) {
                    if (numbers[maxPriceIndex] < numbers[j]) {
                        maxPriceIndex = j;
                    }
                }

                numbers[maxPriceIndex] = 0;
                coupons--;
                maxPriceIndex = 0;
            }

            if (numbers[i] > 100) {
                coupons++;
            }
            sumResult += numbers[i];
        }

        return sumResult;
    }
}
