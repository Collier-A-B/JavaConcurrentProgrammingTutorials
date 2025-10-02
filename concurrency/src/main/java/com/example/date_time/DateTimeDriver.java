package com.example.date_time;

public class DateTimeDriver {
    public static void main(String[] args) {
        System.out.println("Starting DateTimeDriver\n");

        Thread t1 = new Thread(new DateCommand());
        t1.start();

        Thread t2 = new Thread(new CounterCommand());
        t2.start();
    }
}
