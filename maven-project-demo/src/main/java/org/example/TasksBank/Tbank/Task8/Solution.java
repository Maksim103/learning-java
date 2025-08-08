package org.example.TasksBank.Tbank.Task8;

/*
Дана строка s из маленьких букв английского алфавита.
Найдите количество троек (i; j; k), что i < j < k и
si = <<a>>, sj = <<b>>, sk = <<c>>.
*/

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int count = 0;
        for (int k = 0; k < s.length(); k++) {
            for (int j = 0; j < k; j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) == 'a' && s.charAt(j) == 'b' && s.charAt(k) == 'c') {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
