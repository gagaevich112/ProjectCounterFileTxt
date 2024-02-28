package ru.gagich;

import java.io.*;

//управление счетчиком
public class Counter {
    private int value;

    public Counter(int value) {
        this.value = value;
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

    public void setValue(int value) {
        this.value = value;
    }
}