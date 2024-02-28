package ru.gagich;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ProcessorComand {
    private final Counter counter;
    private final CounterFileManager fileManager;

    public ProcessorComand(Counter counter, CounterFileManager fileManager) {
        this.counter = counter;
        this.fileManager = fileManager;
    }

    public void start() {
        System.out.println("Счетчик загружен со сначением: " + counter.getValue());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            while (true) {
                System.out.print("Введите команду (inc - увеличить счетчик, reset - сбросить счетчик, stop - завершить программу):");
                input = reader.readLine();
                if ("inc".equals(input)) {
                    counter.increment();
                    System.out.println("Значение счетчика увеличино. Новое значение: " + counter.getValue());
                    fileManager.writeCounter(counter.getValue());
                } else if ("stop".equals(input)) {
                    System.out.println("Значение счетчика: " + counter.getValue() + " Завершение программы");
                    break;
                } else if ("reset".equals(input)) {
                    counter.reset();
                    System.out.println("Значение счетчика сброшено. Новое значение равно: " + counter.getValue());
                } else {
                    System.out.println("Команда не найдена. Попробуйте снова.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}