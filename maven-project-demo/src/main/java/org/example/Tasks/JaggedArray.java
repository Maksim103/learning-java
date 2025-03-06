package org.example.Tasks;

import java.util.Scanner;

/*

4
3
1 8 9
5
1 -2 3 6 4
6
1 1 1 1 1 1
3
-1 2 5

*/

public class JaggedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] array = new int[n][];

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            array[i] = new int[k];

            for (int j = 0; j < k; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }

            if (maxSum < sum) {
                maxSum = sum;
                maxSumIndex = i;
            }
        }

        System.out.println(maxSumIndex+1);
        System.out.println(maxSum);

        for (int i = 0; i < array[maxSumIndex].length; i++) {
            System.out.printf(array[maxSumIndex][i] + " ");
        }
    }
}
