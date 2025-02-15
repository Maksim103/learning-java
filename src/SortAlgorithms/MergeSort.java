package SortAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] a = new int[] {1, 5};
        int[] b = new int[] {2, 4};

        System.out.println(Arrays.toString(merge(a, b)));
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
