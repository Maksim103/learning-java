package org.example.Tasks.CalculatorTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String pathParent = "C:\\Users\\Leon\\Desktop\\Java_jobs\\Learning\\maven-project-demo\\src\\main\\java\\org\\example\\Tasks\\CalculatorTask\\";
        String outputPathFile = pathParent + "output.txt";
        clearFile(outputPathFile);

        Deque<String> expressions = getInputFile(pathParent + "input.txt");

        while (!expressions.isEmpty()) {
            String[] expression = expressions.pollFirst().split(" ");

            try {
                double a = Double.parseDouble(expression[0]);
                double b = Double.parseDouble(expression[expression.length-1]);
                String operation = expression[1];

                double result = execute(a, b, operation);
                writeExecuteInFile(String.join(" ", expression), String.valueOf(result), outputPathFile);
            } catch (NumberFormatException e) {
                writeExecuteInFile(String.join(" ", expression), "Error! Not number", outputPathFile);
            } catch (ArithmeticException e) {
                writeExecuteInFile(String.join(" ", expression), e.getMessage(), outputPathFile);
            }
        }

        readFile(outputPathFile);
    }

    public static Deque<String> getInputFile(String path) {
        File file = new File(path);
        Deque<String> result = new ArrayDeque<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                result.addLast(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void readFile(String path) {
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeExecuteInFile(String expression, String result, String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(expression + " = " + result);
            writer.write("\n");

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearFile(String path) {
        try (FileWriter _ = new FileWriter(path, false)) {

        } catch (IOException e) {
            System.out.println("Файла нет");
        }
    }

    public static double execute(double a, double b, String operation) throws ArithmeticException {
        switch (operation) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Error! Division by zero");
                }
                return a/b;
            default:
                throw new ArithmeticException("Operation Error!");
        }
    }
}
