package org.example.TasksBank.Tbank.Task1;

/*
Условие:

У Кости есть бумажка, на которой написано n чисел.
Также у него есть возможность не больше, чем k раз, взять любое число с бумажки,
 после чего закрасить одну из старых цифр, а на ее месте написать новую произвольную цифру.

На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?
*/

/*
Данные:

1:
5 2
1 2 1 3 5
Итог: 16

2:
3 1
99 5 85
Итог: 10

3:
1 10
9999
Итог: 0

*/


import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[] numbers = new long[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextLong();
        }

        System.out.println(solution(n, k, numbers));
    }

    public static long solution(int n, int k, long[] numbers) {
        long initialSum = 0;
        for (long number : numbers) {
            initialSum += number;
        }

        HashMap<Integer, Long> dict = new HashMap<>();
        while (k != 0) {
            for (int i = 0; i < numbers.length; i++) {
                int numberLength = String.valueOf(numbers[i]).length();
                for (int j = 0; j < numberLength; j++) {
                    long m = changeDigit(numbers[i], j, 9);

                    if (!dict.containsKey(i)) {
                        dict.put(i, m - numbers[i]);
                    } else if (dict.get(i) < (m - numbers[i])) {
                        dict.put(i, m - numbers[i]);
                    }
                }
            }

            int maxDifferenceKey = 0;
            for (int key : dict.keySet()) {
                if (dict.get(maxDifferenceKey) < dict.get(key)) {
                    maxDifferenceKey = key;
                }
            }

            numbers[maxDifferenceKey] += dict.get(maxDifferenceKey);

            dict.clear();
            k--;
        }

        long finalSum = 0;
        for (long number : numbers) {
            finalSum += number;
        }

        return finalSum - initialSum;
    }

    public static long changeDigit(long num, long k, int newDigit) {
        k = (long) Math.pow(10, k);
        double saved = num % k;
        num = num - (num % (k * 10L));
        return ((long) (num + ((long) newDigit * k) + saved));
    }
}
