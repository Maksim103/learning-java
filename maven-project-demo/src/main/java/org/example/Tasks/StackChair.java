package org.example.Tasks;

import java.util.Scanner;
import java.util.ArrayList;

/*

4
push Футболка
push Рубашка
pop
push Джинсы

*/

public class StackChair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String action = input.split(" ")[0];

            if (action.equals("push")) {
                String item = input.split(" ")[1];
                list.add(item);
            } else if (action.equals("pop")) {
                System.out.println("Петя взял " + list.removeLast());
            }
        }

        for (String item: list) {
            System.out.print(item + " ");
        }
    }
}
