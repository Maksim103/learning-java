package org.example.Tasks;

/*

2
Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
3
арахис - колбаса
клубника - вишня
сгущенка - молоко

*/

import java.util.Scanner;

public class ReplaceTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] text = new String[n];
        for (int i = 0; i < n; i++) {
            text[i] = sc.nextLine();
        }

        int m = sc.nextInt();
        sc.nextLine();
        String[] products = new String[m];
        for (int i = 0; i < m; i++) {
            products[i] = sc.nextLine();
        }

        for (int i = 0; i < text.length; i++) {
            for (String product : products) {
                String allergyProduct = product.split(" - ")[0];
                String replaceProduct = product.split(" - ")[1];

                String[] words = text[i].split(" ");
                for (int k = 0; k < words.length; k++) {
                    if (words[k].equalsIgnoreCase(allergyProduct)) {
                        if (Character.isUpperCase(words[k].charAt(0))) {
                            words[k] = Character.toUpperCase(replaceProduct.charAt(0)) + replaceProduct.substring(1).toLowerCase();
                            continue;
                        }

                        words[k] = replaceProduct;
                    }
                }

                text[i] = String.join(" ", words);
            }
        }

        System.out.println(String.join("\n", text));
    }
}
