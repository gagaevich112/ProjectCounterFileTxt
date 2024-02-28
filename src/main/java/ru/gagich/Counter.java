package ru.gagich;

import java.io.*;

//управление счетчиком
public class Counter {
    private static final String SAVE_FILE = "counter.txt";
    private int value;

    public Counter() {
        this.value = load();
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset() {
        value = 0;
    }

    private int load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load counter. Starting from zero.");
        }
        return 0;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            writer.write(String.valueOf(value));
        } catch (IOException e) {
            System.err.println("Failed to save counter.");
        }
    }
}