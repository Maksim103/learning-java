package org.example.AlgorithmsAndStructures;

public class ChangeDigit {

    public static void main(String[] args) {
        System.out.println(changeDigit(422, 2, 9));
    }

    public static long changeDigit(long num, long k, int newDigit) {
        k = (long) Math.pow(10, k);
        double saved = num % k;
        num = num - (num % (k * 10L));
        return ((long) (num + (newDigit * k) + saved));
    }
}
