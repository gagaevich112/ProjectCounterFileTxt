package ru.gagich;

public class Main {
    public static void main(String[] args) {
        CounterFileManager fileManager = new CounterFileManager("counter.txt");
        int initialValue = fileManager.readCounter();
        Counter counter = new Counter(initialValue);
        ProcessorComand processorComand = new ProcessorComand(counter, fileManager);
        processorComand.start();
    }
}