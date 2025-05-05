package org.example.Algorithms.Grok_Algorithms.Exercise_4_1;

/*
Написать рекурсивную функцию sum
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {3, 5, 2, 6, 1, 3, 5}; // 25
        System.out.println(sum(array));
    }

    public static int sum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + sum(newArray);
    }
}
