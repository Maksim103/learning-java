package org.example.AlgorithmsAndStructures.AlgorithmicTasks;

/*
Мальчик подошел к лестнице. С каждой ступенькой на ней у него ассоциирован какой-то момент из
жизни, который при воспоминании изменит его текущее настроение на аi. Мальчик умеет
перешагивать на следующую ступеньку, либо перепрыгивать через ступеньку. Еще мальчик умеет
абстрагироваться от воспоминаний и проходить вперед на любое количество ступенек, не изменяя
свое настроение (в том числе и оказаться на последней ступеньке), но так как он еще недостаточно
взрослый, он может сделать это не более к раз. Какое максимальное настроение он может получить,
оказавшись на последней ступеньке?

Входные данные
В первой строке вводятся два целых числа (1 n 1000) и k (0 k 100). Во второй строке
вводятся целых чисел аi - изменение настроения, если наступить на і-ю ступеньку
(снизу вверх).

Выходные данные
Выведите единственное число - максимальное настроение, которое он может получить, оказавшись
на последней ступеньке.

Примечание
Изначально мальчик стоит перед первой ступенькой (не на ней).
*/

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(solution(array, k));
    }

    public static int solution(int[] array, int k) {
        int maxMood = 0;
        boolean isCanOverstep = true;

        for (int i = 0; i < array.length; i++) {
            if (k > 0) {
                int minMoodIndex = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] < 0 && array[j] < array[minMoodIndex]) {
                        minMoodIndex = j;
                    }
                }

                if (array[minMoodIndex] < 0) {
                    array[minMoodIndex] = 0;
                    k--;
                }
            }

            if (isCanOverstep) {
                int minMoodIndex = 0;
                for (int j = 0; j < array.length; j++) {
                    if (j != array.length-1 && array[j] < 0 && array[j] < array[minMoodIndex]
                            && array[j+1] != 0) {
                        minMoodIndex = j;
                    }
                }

                if (minMoodIndex == 0 && array[minMoodIndex] < 0) {
                    isCanOverstep = false;
                    continue;
                } else {

                    if (minMoodIndex == i && array[minMoodIndex] < 0) {
                        isCanOverstep = false;
                        continue;
                    }
                }
            }

            maxMood += array[i];
        }

        return maxMood;
    }
}