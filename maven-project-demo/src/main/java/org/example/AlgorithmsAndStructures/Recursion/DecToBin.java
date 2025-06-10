package org.example.AlgorithmsAndStructures.Recursion;

import java.util.Scanner;

// 100 - 1100100

public class DecToBin {
    public static String decToBin(int value, StringBuilder result) {
        if (value == 0) {
            return result.toString();
        }

        result.append(value%2);
        return decToBin(value/2, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        System.out.println(decToBin(value, new StringBuilder()));
    }
}
