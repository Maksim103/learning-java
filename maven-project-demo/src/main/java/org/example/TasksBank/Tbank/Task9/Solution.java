package org.example.TasksBank.Tbank.Task9;

/*
Вам дана последовательность А, изначально состоящая из одного элемента 0 (А = (0)) и строка S
длины N, состоящая только из символов <<L>> и <<R>>.

Затем вы проделаете следующую операцию для і = 1, 2, 3, …, N:
Если Si = L, то вы вставите число і слева от числа i - 1 в последовательность А.
Если Si = R, то вы вставите число і справа от числа - 1 в последовательность A.
Найдите последовательность, которая получится после всех операций.

Входные данные
В первой строке вводится одно целое число N (1 < N < 5*10^5) - длина строки S.
Во второй строке вводится строка S (|S| = N). Гарантируется, что S состоит только из символов <<L>> И <<R>>.

Выходные данные
Выведите N + 1 число через пробел - последовательность А, которая получится в результате
применения N операций.

Примечание:
В примере "LRRRL" последовательность будет меняться так:
1. S1 = L, вы вставите 1 слева от 0. (0) -> (1,0)
2. S2 = R, вы вставите 2 справа от 1. (1, 0) -> (1, 2, 0)
3. S3 = R, вы вставите 3 справа от 2. (1, 2,0) -> (1, 2, 3,0)
4. S4 = R, вы вставите 4 справа от 3. (1, 2,3, 0) -> (1,2,3, 4, 0)
5. S5 = L, вы вставите 5 слева от 4. (1, 2, 3, 4, 0) -> (1, 2, 3, 5, 4, 0)
Таким образом, после всехопераций А = (1, 2, 3, 5, 4, 0).
*/


import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        LinkedList<Integer> list = solution(s);
        list.forEach((x) -> System.out.print(x + " "));
    }

    public static LinkedList<Integer> solution(String s) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(0);

        int i = 0;
        int k = 0;
        while (true) {
            if (k == s.length()) {
                break;
            }

            if (s.charAt(k) == 'L') {
                result.add(i, k+1);
            } else if (s.charAt(k) == 'R') {
                i++;
                result.add(i, k+1);
            }

            k++;
        }

        return result;
    }
}
