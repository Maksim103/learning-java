package Tasks;

import java.util.Scanner;

public class FindSumAvgLines {
    public static double findSumAvgLines(int[][] arr){
        double average = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }

            average += (sum/(double)arr[i].length);
        }

        return average;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findSumAvgLines(arr));
    }
}
