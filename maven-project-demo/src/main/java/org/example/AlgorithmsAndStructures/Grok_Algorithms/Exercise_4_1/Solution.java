package org.example.AlgorithmsAndStructures.Grok_Algorithms.Exercise_4_1;

/*
Написать рекурсивную функцию sum
*/

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {3, 5, 2, 6, 1, 3, 5}; // 25
        System.out.println(sum(array, 0));
    }

    public static int sum(int[] array, int index) {
        if (index == (array.length-1)) {
            return array[index];
        }

        return array[index] + sum(array, index+1);
    }
}
