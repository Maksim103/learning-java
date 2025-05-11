package org.example.AlgorithmsAndStructures.Grok_Algorithms.Exercise_4_2;

/*
Написать рекурсивную функцию countingElements
*/

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {3, 4, 1, 24, 142, 4, 21, 41, 4, 141, 24, 1}; // 12
        System.out.println(countingElements(array, 0));
    }

    public static int countingElements(int[] array, int count) {
        if (count == array.length) {
            return count;
        }

        return countingElements(array, count+1);
    }
}
