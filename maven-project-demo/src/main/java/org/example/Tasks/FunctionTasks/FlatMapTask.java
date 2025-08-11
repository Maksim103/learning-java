package org.example.Tasks.FunctionTasks;

/*
300040005000 3
Молоко 244 2
Сметана 194 1
Кефир 180 1
500060007000 2
Кефир 180 2
Апельсины 739 1.5
800090001000 1
Молоко 244 3
end
*/

/*
Апельсины;739
Кефир;180
Молоко;244
Сметана;194
*/

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PurchaseClass> purchaseClasses = new ArrayList<>();
        String text;

        while (!(text = scanner.nextLine()).equals("end")) {
            String[] data = text.split(" +");
            PurchaseClass purchaseClass = new PurchaseClass(data[0]);
            int n = Integer.parseInt(data[1]);

            for (int i = 0; i < n; i++) {
                String[] commodityData = scanner.nextLine().split(" +");
                purchaseClass.addItem(new Commodity(commodityData[0], Integer.parseInt(commodityData[1])),
                        Double.parseDouble(commodityData[2]));
            }

            purchaseClasses.add(purchaseClass);
        }

        Set<Commodity> commoditySet = purchaseClasses.stream().flatMap(x -> x.getCommodities().keySet().stream())
                .sorted(Comparator.comparing(x -> x.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        commoditySet.stream().forEach(System.out::println);
    }
}

class PurchaseClass {
    private String bankCardNumber;
    private final Map<Commodity, Double> commodities = new HashMap<>();

    public PurchaseClass(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public Map<Commodity, Double> getCommodities() {
        return commodities;
    }

    public void addItem(Commodity item, Double number) {
        commodities.put(item, number);
    }
}

class Commodity {
    private String name;
    private int price;

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;

        return (this.name.equals(commodity.name)) && (this.price == commodity.price);
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }
}
