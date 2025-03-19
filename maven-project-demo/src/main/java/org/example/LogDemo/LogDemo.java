package org.example.LogDemo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {
    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.FINE, "Start program");

        try {
            randomlyFailingAlgorithm();
        } catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE, "Exception caught", e);
            System.exit(1);
        }

        LOGGER.log(Level.FINE, "Finished successfully");
    }

    private static void randomlyFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generate random number");

        if (randomNumber < 0.5) {
            throw new IllegalStateException("Invalid number");
        }
    }
}
