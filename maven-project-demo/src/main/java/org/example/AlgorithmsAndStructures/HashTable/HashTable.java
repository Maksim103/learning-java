package org.example.AlgorithmsAndStructures.HashTable;

class DataItem {
    private int data;

    public DataItem(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }
}

public class HashTable {
    private DataItem[] hashArray;
    private int sizeArray;
    DataItem nonItem = new DataItem(-1);

    public HashTable(int size) {
        this.sizeArray = size;
        hashArray = new DataItem[sizeArray];
    }

    public void displayTable() {
        for (int i = 0; i < sizeArray; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getKey() + " ");
            }
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % sizeArray;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashIndex = hashFunc(key);

        while (hashArray[hashIndex] != null && hashArray[hashIndex].getKey() != -1) {
            hashIndex++;
            hashIndex %= sizeArray;
        }
        hashArray[hashIndex] = item;
    }

    public DataItem delete(int key) {
        int hashIndex = hashFunc(key);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].getKey() == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = nonItem;
                return temp;
            }
            hashIndex++;
            hashIndex %= sizeArray;
        }

        return null;
    }

    public DataItem find(int key) {
        int hashIndex = hashFunc(key);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].getKey() == key) {
                return hashArray[hashIndex];
            }
            hashIndex++;
            hashIndex %= sizeArray;
        }

        return null;
    }
}
