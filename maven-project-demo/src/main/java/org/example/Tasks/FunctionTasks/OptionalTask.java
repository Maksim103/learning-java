package org.example.Tasks.FunctionTasks;

/*
1.
Апельсины;649;1
Мука "Лидская";290;2
Абрикосы;799;1
Йогурт "Греческий";141;4
Айран "Савушкин";149;1
end

2.
Зубная паста "32 жемчужины";291;4
Мыло "Детское";177;7
Авокадо "Хасс";189;1
Акварель медовая;829;2
Кефир;178;3
end

3.
Сосиски "Докторские";471;2
Колбаса "Мортаделла";541;2
Чипсы мясные;245;3
Стейк из филе индейки;2859;1
end
*/

/*
1.
Первая покупка на букву М: Мука "Лидская";290;2;580
Первая покупка со стоимостью больше 1000: Покупка не найдена;0;0;0

2.
Первая покупка на букву М: Мыло "Детское";177;7;1239
Первая покупка со стоимостью больше 1000: Зубная паста "32 жемчужины";291;4;1164

3.
Первая покупка на букву М: Покупка не найдена;0;0;0
Первая покупка со стоимостью больше 1000: Колбаса "Мортаделла";541;2;1082
*/

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class OptionalTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Purchase> list = new ArrayList<>();
        String str = scan.nextLine();

        while (!"end".equals(str)) {
            String[] parts = str.split(";");
            list.add(new Purchase(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            str = scan.nextLine();
        }

        Optional<Purchase> purchase1 = findFirst(list, x -> x.getName().startsWith("М"));
        Optional<Purchase> purchase2 = findFirst(list, x -> x.getCost() > 1000);

        System.out.println("Первая покупка на букву М: " + purchase1.orElseGet(() -> new Purchase(
                "Покупка не найдена", 0, 0)));
        System.out.println("Первая покупка со стоимостью больше 1000: " + purchase2.orElseGet(() -> new Purchase(
                "Покупка не найдена", 0, 0)));
    }

    public static Optional<Purchase> findFirst(ArrayList<Purchase> list, Predicate<Purchase> filter) {
        Purchase result = null;
        for (Purchase purchase: list) {
            if (filter.test(purchase)) {
                result = purchase;
                break;
            }
        }

        return Optional.ofNullable(result);
    }
}

class Purchase {
    private String name;
    private int price;
    private int count;

    public Purchase(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return price * count;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }
}