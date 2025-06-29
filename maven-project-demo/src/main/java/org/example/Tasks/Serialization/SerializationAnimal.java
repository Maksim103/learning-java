package org.example.Tasks.Serialization;

import java.io.*;

public class SerializationAnimal {
    public static void main(String[] args) throws IOException {
        int size = 3;

        Animal[] animals = new Animal[size];
        animals[0] = new Animal("Elephant");
        animals[1] = new Animal("Tiger");
        animals[2] = new Animal("Monkey");

        byte[] data = serializeAnimalArray(size, animals);
        Animal[] deAnimals = deserializeAnimalArray(data);

        for (Animal animal: deAnimals) {
            System.out.println(animal);
        }
    }

    public static byte[] serializeAnimalArray(int size, Animal[] animals) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);

        outputStream.writeInt(size);
        for (int i = 0; i < size; i++) {
            outputStream.writeObject(animals[i]);
        }

        outputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] result;

        try (ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = inputStream.readInt();

            if (size < 0) {
                throw new IllegalArgumentException();
            }

            result = new Animal[size];

            for (int i = 0; i < size; i++) {
                Object obj = inputStream.readObject();

                if (!(obj instanceof Animal)) {
                    throw new IllegalArgumentException();
                }

                result[i] = (Animal) obj;
            }

            return result;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }
}
