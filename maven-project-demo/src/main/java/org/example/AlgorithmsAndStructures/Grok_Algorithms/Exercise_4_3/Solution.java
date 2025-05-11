package org.example.AlgorithmsAndStructures.Grok_Algorithms.Exercise_4_3;

/*
Написать рекурсивную функцию maxElement
*/

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {3888888, -231, 4342, 11, 6000000, 34, 231, 7777};
        System.out.println(maxElement(array, 0));
    }


    public static int maxElement(int[] array, int index) {
        if (index == (array.length-1)) {
            return array[index];
        }

        if (array[index] > maxElement(array, index+1)) {
            return array[index];
        } else {
            return maxElement(array, index+1);
        }
    }
}
