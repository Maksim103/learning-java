package org.example.Tasks;

import java.util.Scanner;

public class BinaryTranslation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                builder.append(input.charAt(i));
            } else if (!builder.isEmpty()) {
                int number = Integer.parseInt(builder.toString());
                System.out.print(Integer.toBinaryString(number));

                builder.setLength(0);
                System.out.print(input.charAt(i));
            } else {
                System.out.print(input.charAt(i));
            }
        }

        if (!builder.isEmpty()) {
            int number = Integer.parseInt(builder.toString());
            System.out.print(Integer.toBinaryString(number));
        }
    }
}
