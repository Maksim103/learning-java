package SortAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] n = new int[] {4, 1, 9, -4, 7, 1, 0, -23};

        System.out.println("Сортировка пузырьком");
        System.out.println(Arrays.toString(sort(n)));
    }

    public static int[] sort(int[] numbers){
        int[] result = Arrays.copyOf(numbers, numbers.length);
        int count = 0;

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result.length-1-i; j++) {
                if (result[j] > result[j+1]){
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }

                count++;
            }
        }

        System.out.println(count + " - Кол-во обходов");
        return result;
    }
}
