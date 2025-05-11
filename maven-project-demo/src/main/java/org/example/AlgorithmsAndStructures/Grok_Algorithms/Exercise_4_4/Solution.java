package org.example.AlgorithmsAndStructures.Grok_Algorithms.Exercise_4_4;

/*
Написать рекурсивную функцию binSearch
*/

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {-234, -11, 0, 42, 4223, 84393, 123949, 999999999};
        int index = binSearch(array, 0, array.length-1, -11);

        System.out.println(index);
        System.out.println(array[index]);
    }

    public static int binSearch(int[] array, int left, int right, int target) {
        if (right >= left) {
            int middle = (left + right) / 2;

            if (array[middle] == target) {
                return middle;
            } else if (array[middle] > target) {
                return binSearch(array, left, right-1, target);
            } else {
                return binSearch(array, left+1, right, target);
            }
        }

        return -1;
    }
}
