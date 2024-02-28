package ru.gagich;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ProcessorComand {
    private Counter counter;

    public ProcessorComand(Counter counter) {
        this.counter = counter;
    }

    public void start() {
        System.out.println("Counter loaded. Value: " + counter.getValue());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            while (true) {
                System.out.print("Enter command (/inc, /stop, /reset): ");
                input = reader.readLine();
                if ("/inc".equals(input)) {
                    counter.increment();
                    System.out.println("Counter incremented. Current value: " + counter.getValue());
                    counter.save();
                } else if ("/stop".equals(input)) {
                    System.out.println("Counter value: " + counter.getValue());
                    System.out.println("Shutting down.");
                    break;
                } else if ("/reset".equals(input)) {
                    counter.reset();
                    System.out.println("Counter reset to zero.");
                    counter.save();
                } else {
                    System.out.println("Unknown command. Try again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}