package org.example.Tasks;

import java.util.Scanner;

public class SecondMax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  // 2 3 4 5 8 7 4 0
        int n = sc.nextInt();
        int max1 = 0;
        int max2 = 0;

        while (n != 0) {
            if (max1 < n) {
                max2 = max1;
                max1 = n;
            }

            if (max1 > n && max2 < n) {
                max2 = n;
            }

            n = sc.nextInt();
        }

        System.out.print(max2);
    }
}
