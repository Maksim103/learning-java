package SortAlgorithms;

import java.util.Arrays;

/**
 * <b>Counting Sorting is an algorithm without comparison.</b>
 * <p> The main idea of the algorithm is to calculate how many times each element occurs in the array,
 * and then fill the source array with the results of this calculation.</p>
 * <b>Sorting by counting works best in these conditions:</b>
 * <ul>
 *     <li>the array is very large — there are many values in it;</li>
 *     <li>these values are in a range known to us;</li>
 *     <li>the range is much smaller than the size of the array, which means that data units can be repeated.</li>
 * </ul>
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] n = new int[] {45, 12, 53, 22, 5, 1, 99, 5, 2, 1, 12}; // numbers do not exceed one hundred

        System.out.println("Сортировка подсчётом");
        System.out.println(Arrays.toString(sort(n, 100)));
    }

    public static int[] sort(int[] array, int max) {
        int[] result = new int[array.length];
        int[] supportArray = new int[max];

        for (int value : array) {
            supportArray[value]++;
        }

        int k = 0;
        for (int i = 0; i < max; i++) {
            if (supportArray[i] > 0) {
                for (int j = 0; j < supportArray[i]; j++) {
                    result[k] = i;
                    k++;
                }
            }
        }

        return result;
    }
}
