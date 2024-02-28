package ru.gagich;

import java.io.*;

public class CounterFileManager {
    private final String fileName;

    public CounterFileManager(String fileName) {
        this.fileName = fileName;
    }

    public int readCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Не удалось прочитать файл счетчика. Создаем новый");
        }
        return 0;
    }

    public void writeCounter(int value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(value));
        } catch (IOException e) {
            System.err.println("Не удалось прочитать файл счетчика");
        }
    }
}