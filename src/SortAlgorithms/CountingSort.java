package SortAlgorithms;

import java.util.Arrays;

/**
 * Counting Sorting is an algorithm without comparison.
 * The main idea of the algorithm is to calculate how many times each element occurs in the array,
 * and then fill the source array with the results of this calculation.
 *
 * Sorting by counting works best in these conditions:
 * the array is very large — there are many values in it;
 * these values are in a range known to us;
 * the range is much smaller than the size of the array, which means that data units can be repeated.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] n = new int[] {-31, 552, 124, -481, 12, -1, 0, 2235, 1, 3};

        System.out.println("Сортировка подсчётом");
        System.out.println(Arrays.toString(sort(n)));
    }

    public static int[] sort(int[] array) {
        int[] result = new int[array.length];



        return result;
    }
}
