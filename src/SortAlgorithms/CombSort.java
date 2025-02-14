package SortAlgorithms;

import java.util.Arrays;

public class CombSort {
    public static void main(String[] args) {
        int[] n = new int[] {-31, 552, 124, -481, 12, -1, 0, 2235, 1, 3};

        System.out.println("Сортировка расчёской");
        System.out.println(Arrays.toString(sort(n)));
    }

    public static int[] sort(int[] numbers){
        final double factor = 1.247;
        int[] result = Arrays.copyOf(numbers, numbers.length);

        int difference = (int)Math.round(result.length / factor);
        int count = 0;

        while (difference > 1){
            for (int j = 0; j < result.length-1; j++) {
                if ((j+difference-1) < result.length){
                    if (result[j] > result[j+difference-1]){
                        int temp = result[j];
                        result[j] = result[j+difference-1];
                        result[j+difference-1] = temp;
                    }
                }
                else{
                    break;
                }

                count++;
            }

            difference = (int)(difference / factor);
        }

        System.out.println(count + " - Кол-во обходов");
        return result;
    }
}
