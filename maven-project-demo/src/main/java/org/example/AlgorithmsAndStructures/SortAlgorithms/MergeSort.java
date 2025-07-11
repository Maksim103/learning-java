package org.example.AlgorithmsAndStructures.SortAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] n = new int[] {-31, 552, 124, -481, 12, -1, 0, 2235, 1, 3};

        System.out.println("Сортировка слиянием");
        System.out.println(Arrays.toString(mergeSort(n)));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int half = array.length/2;

        int[] a = Arrays.copyOfRange(array, 0, half);
        int[] b = Arrays.copyOfRange(array, half, array.length);

        return merge(mergeSort(a), mergeSort(b));
    }

    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];

        int k = 0, i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]){
                result[k] = b[j];
                j++;
            }
            else {
                result[k] = a[i];
                i++;
            }

            k++;
        }

        while (i < a.length){
            result[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length){
            result[k] = b[j];
            k++;
            j++;
        }

        return result;
    }
}
