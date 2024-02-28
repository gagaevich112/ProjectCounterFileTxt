package ru.gagich;

public class Main {
    public static void main(String[] args){
        Counter counter= new Counter();
        ProcessorComand processorComand = new ProcessorComand(new Counter());
        processorComand.start();

    }
}