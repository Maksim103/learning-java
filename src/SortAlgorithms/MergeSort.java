package SortPackage;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] a = new int[] {5, 8};
        int[] b = new int[] {-1, 6};

        merge(a, b);
    }

    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while ((i < a.length) && (j < b.length)) {
            if (a[i] >= b[j]){
                result[k] = b[j];
                j++;
            }
            else if (b[j] >= a[i]){
                result[k] = a[i];
                i++;
            }

            k++;
        }

        System.out.println(Arrays.toString(a) + " - a || " + i + " - i");
        System.out.println(Arrays.toString(b) + " - b || " + j + " - j");
        System.out.println(Arrays.toString(result));

        return result;
    }
}
