package SortAlgorithms;

import java.util.Arrays;

// 2.0 version
public class CombSort {
    public static void main(String[] args) {
        int[] n = new int[] {4, 1, 9, -4, 7, 1, 0, -23};

        System.out.println("Сортировка расчёской");
        System.out.println(Arrays.toString(sort(n)));
    }

    public static int[] sort(int[] numbers){
        final double factor = 1.247;

        int[] result = Arrays.copyOf(numbers, numbers.length);
        int difference = (int)Math.round(result.length / factor);
        int count = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length-i-1; j++) {
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

            difference = (int)Math.round(difference / factor);
        }

        System.out.println(count + " - Кол-во обходов");
        return result;
    }
}
