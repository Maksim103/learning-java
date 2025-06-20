package org.example.AlgorithmsAndStructures.HashTable;

public class HashTableExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.insert(new DataItem(10));
        hashTable.insert(new DataItem(20));
        hashTable.insert(new DataItem(30));
        hashTable.insert(new DataItem(40));

        hashTable.displayTable();

        hashTable.delete(10);
        hashTable.displayTable();

        System.out.println("Поиск элемента с ключом 30");
        System.out.println(hashTable.find(30));
        System.out.println(hashTable.find(30).getKey());
    }
}