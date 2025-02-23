package Algorithms;

import java.util.Scanner;

public class UniqueValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(uniqueValues(arr));
    }

    public static int uniqueValues(int[] arr){
        int uniqueCount = 0;

        OUTER:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    continue OUTER;
                }
            }

            uniqueCount++;
        }

        return uniqueCount;
    }
}
